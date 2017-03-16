package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // add numbers
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "lutti", R.drawable.number_one, R.color.category_numbers_light));
        words.add(new Word("two", "otiiko", R.drawable.number_two, R.color.category_numbers_light));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.color.category_numbers_light));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.color.category_numbers_light));
        words.add(new Word("five", "massokka", R.drawable.number_five, R.color.category_numbers_light));
        words.add(new Word("six", "temmokka", R.drawable.number_six, R.color.category_numbers_light));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.color.category_numbers_light));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.color.category_numbers_light));
        words.add(new Word("nine", "wo'e", R.drawable.number_nine, R.color.category_numbers_light));
        words.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.color.category_numbers_light));

        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.numbers_list_view);
        listView.setAdapter(adapter);
    }
}
