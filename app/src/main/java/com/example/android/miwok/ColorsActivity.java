package com.example.android.miwok;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    // MediaPlayer class to
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


    /**
     * This method creates the ColorsActivity
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState) {

        // set the xml file of this activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        // Set AudioManager system service
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // ArrayList of the object Word which stores the data
        ArrayList<Word> words = addData();

        // A custom adapter (WordAdapter) which helps us arrange the items in the ListView
        final WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors_light);
        ListView listView = (ListView) findViewById(R.id.colors_list_view);
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
                    mediaPlayer = MediaPlayer.create(ColorsActivity.this,
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
        words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
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
