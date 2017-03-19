package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    // MediaPlayer class to play audio files
    private MediaPlayer mediaPlayer;

    // AudioManager instance
    private AudioManager audioManager;

    // AudioManager onAudioFocusChange Listener
    AudioManager.OnAudioFocusChangeListener audioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {

        @Override
        public void onAudioFocusChange(int focusChange) {

            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){

                // AUDIOFOCUS_LOSS_TRANSIENT is a constant variable which indicates that we lost
                // a transient of the audio focus
                // AUDIO_LOSS_TRANSIENT_CAN_DUCK is a constant variable which indicates that we
                // lost the transient of the audio focus, but the audio can still lower its level
                // and not completely stop the streaming (depends on the app and developer)
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if(focusChange == AudioManager.AUDIOFOCUS_GAIN){

                // AUDIOFOCUS_GAIN is a constant variable which indicates that the app has gained
                // audio focus again
                mediaPlayer.start();
            } else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){

                // AUDIOFOCUS_LOSS is a constant variable which indicates that the app has lost
                // any audio focus for an unknown duration
                releaseMediaPlayer(mediaPlayer);
            }
        }
    };


    protected void onCreate(Bundle savedInstanceState) {


        // set the xml file of this activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Set AudioManager system service
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // ArrayList of the object Word which stores the data
        ArrayList<Word> words = addData();

        // A custom adapter (WordAdapter) which helps us arrange the items in the ListView
        final WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers_light);
        ListView listView = (ListView) findViewById(R.id.numbers_list_view);
        listView.setAdapter(adapter);



        /**
         * Play respective audio when an item from the ListView is clicked
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                // get the word (item on the list) which was clicked
                Word currentWord = adapter.getItem(position);

                // first release the memory which was used by the previous action
                // of the media player
                releaseMediaPlayer(mediaPlayer);
                // get audio focus request
                int request = audioManager.requestAudioFocus(audioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(request == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    // get the resource file and create an audible MediaPlayer object
                    mediaPlayer = MediaPlayer.create(NumbersActivity.this,
                            currentWord.getAudioResourceId());
                    // start playing
                    mediaPlayer.start();
                    // set what happens when the audio is finished playing
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {

                            // free up the memory which was used by the MediaPlayer instance
                            releaseMediaPlayer(mediaPlayer);
                        }
                    });
                }

            }
        });
    }


    /**
     * This method frees up the memory which is used by the MediaPlayer instance
     * @param mediaPlayer - MediaPlayer instance
     */
    private void releaseMediaPlayer(MediaPlayer mediaPlayer) {

        // see if it is initialized with some data
        if(mediaPlayer != null){

            // release the memory
            mediaPlayer.release();
            // set it to uninitialized
            mediaPlayer = null;
            // abandon audio focus request
            audioManager.abandonAudioFocus(audioFocusChangeListener);
        }
    }


    /**
     * This method returns the data grabbed from the resource files
     * @return words - an ArrayList of the object Word
     */
    private ArrayList<Word> addData() {

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));
        return words;
    }



    /**
     * This method puts the ColorsActivity in the background
     * the activity is deleted when memory is needed for other
     * processes.
     */
    protected void onStop() {

        // put this activity in background
        super.onStop();
        // release the memory which the audio player had used
        releaseMediaPlayer(mediaPlayer);
    }
}
