package com.example.android.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private static final int NOT_DEFINED = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "minto wuksus", NOT_DEFINED, R.color.category_phrases_light));
        words.add(new Word("What is your name?", "tinnә oyaase'nә", NOT_DEFINED, R.color.category_phrases_light));
        words.add(new Word("My name is...", "oyaaset...", NOT_DEFINED, R.color.category_phrases_light));
        words.add(new Word("How are you feeling?", "michәksәs?", NOT_DEFINED, R.color.category_phrases_light));
        words.add(new Word("I’m feeling good.", "kuchi achit", NOT_DEFINED, R.color.category_phrases_light));
        words.add(new Word("Are you coming?", "әәnәs'aa?", NOT_DEFINED, R.color.category_phrases_light));
        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", NOT_DEFINED, R.color.category_phrases_light));
        words.add(new Word("I’m coming.", "әәnәm", NOT_DEFINED, R.color.category_phrases_light));
        words.add(new Word("Let’s go.", "yoowutis", NOT_DEFINED, R.color.category_phrases_light));
        words.add(new Word("Come here.", "әnni'nem", NOT_DEFINED, R.color.category_phrases_light));

        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.phrases_list_view);
        listView.setAdapter(adapter);
    }
}
