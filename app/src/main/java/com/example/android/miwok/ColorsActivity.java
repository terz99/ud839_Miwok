package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.color.category_colors_light));
        words.add(new Word("green", "chokokki", R.drawable.color_green, R.color.category_colors_light));
        words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.color.category_colors_light));
        words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.color.category_colors_light));
        words.add(new Word("black", "kululli", R.drawable.color_black, R.color.category_colors_light));
        words.add(new Word("white", "kelelli", R.drawable.color_white, R.color.category_colors_light));
        words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.color.category_colors_light));
        words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.color.category_colors_light));

        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.colors_list_view);
        listView.setAdapter(adapter);
    }
}
