package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {


    // MediaPlayer class to play audio files
    private MediaPlayer mediaPlayer;

    /**
     * This method creates the ColorsActivity
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState) {

        // set the xml file of this activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        // ArrayList of the object Word which stores the data
        ArrayList<Word> words = addData();

        // A custom adapter (WordAdapter) which helps us arrange the items in the ListView
        final WordAdapter adapter = new WordAdapter(this, words, R.color.category_family_light);
        ListView listView = (ListView) findViewById(R.id.family_list_view);
        listView.setAdapter(adapter);



        /**
         * Play respective audio when an item from the ListView is clicked
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Word currentWord = adapter.getItem(position);

                mediaPlayer = MediaPlayer.create(FamilyActivity.this, currentWord.getAudioResourceId());
                mediaPlayer.start();
            }
        });
    }



    /**
     * This method returns the data grabbed from the resource files
     * @return words - an ArrayList of the object Word
     */
    private ArrayList<Word> addData() {

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "әpә", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
        words.add(new Word("daugther", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));
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
    }
}
