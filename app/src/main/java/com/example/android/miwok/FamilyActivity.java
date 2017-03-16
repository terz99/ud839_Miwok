package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "әpә", R.drawable.family_father, R.color.category_family_light));
        words.add(new Word("mother", "әṭa", R.drawable.family_mother, R.color.category_family_light));
        words.add(new Word("son", "angsi", R.drawable.family_son, R.color.category_family_light));
        words.add(new Word("daugther", "tune", R.drawable.family_daughter, R.color.category_family_light));
        words.add(new Word("older brother", "taachi", R.drawable.family_older_brother, R.color.category_family_light));
        words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.color.category_family_light));
        words.add(new Word("older sister", "teṭe", R.drawable.family_older_sister, R.color.category_family_light));
        words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.color.category_family_light));
        words.add(new Word("grandmother", "ama", R.drawable.family_grandmother, R.color.category_family_light));
        words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather, R.color.category_family_light));

        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.family_list_view);
        listView.setAdapter(adapter);
    }
}
