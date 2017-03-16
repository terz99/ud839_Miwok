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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "minto wuksus", R.mipmap.ic_launcher));
        words.add(new Word("What is your name?", "tinnә oyaase'nә", R.mipmap.ic_launcher));
        words.add(new Word("My name is...", "oyaaset...", R.mipmap.ic_launcher));
        words.add(new Word("How are you feeling?", "michәksәs?", R.mipmap.ic_launcher));
        words.add(new Word("I’m feeling good.", "kuchi achit", R.mipmap.ic_launcher));
        words.add(new Word("Are you coming?", "әәnәs'aa?", R.mipmap.ic_launcher));
        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.mipmap.ic_launcher));
        words.add(new Word("I’m coming.", "әәnәm", R.mipmap.ic_launcher));
        words.add(new Word("Let’s go.", "yoowutis", R.mipmap.ic_launcher));
        words.add(new Word("Come here.", "әnni'nem", R.mipmap.ic_launcher));

        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.phrases_list_view);
        listView.setAdapter(adapter);
    }
}
