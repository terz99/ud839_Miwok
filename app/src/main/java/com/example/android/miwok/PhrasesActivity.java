package com.example.android.miwok;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    // MediaPlayer class to play audio files
    private MediaPlayer mediaPlayer;


    protected void onCreate(Bundle savedInstanceState) {

        // set the xml file of this activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        // ArrayList of the object Word which stores the data
        ArrayList<Word> words = addData();

        // A custom adapter (WordAdapter) which helps us arrange the items in the ListView
        final WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases_light);
        ListView listView = (ListView) findViewById(R.id.phrases_list_view);
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
                // get the resource file and create an audible MediaPlayer object
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, currentWord.getAudioResourceId());
                // start playing
                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {

                        // free up the memory which was used by the MediaPlayer instance
                        releaseMediaPlayer(mediaPlayer);
                    }
                });
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
        }
    }


    /**
     * This method returns the data grabbed from the resource files
     * @return words - an ArrayList of the object Word
     */
    private ArrayList<Word> addData() {

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        words.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));
        return words;
    }



    /**
     * This method puts the ColorsActivity in the background
     * the activity is deleted when memory is needed for other
     * processes.
     */
    protected void onPause() {

        super.onPause();

        mediaPlayer.stop();
        releaseMediaPlayer(mediaPlayer);
    }
}
