/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.constraint.solver.SolverVariable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find TextViews by their IDs
        TextView numbersTextView = (TextView) findViewById(R.id.numbers);
        TextView phrasesTextView = (TextView) findViewById(R.id.phrases);
        TextView familyTextView = (TextView) findViewById(R.id.family);
        TextView colorsTextView = (TextView) findViewById(R.id.colors);

        //Set new typeface to all the TextViews
        Typeface fabricaTypeface = Typeface.createFromAsset(getAssets(), "fonts/Fabrica.otf");
        numbersTextView.setTypeface(fabricaTypeface);
        phrasesTextView.setTypeface(fabricaTypeface);
        familyTextView.setTypeface(fabricaTypeface);
        colorsTextView.setTypeface(fabricaTypeface);

        // set click listeners
        numbersTextView.setOnClickListener(new OnClickListener(){

            public void onClick(View view) {

                Intent newActivity = new Intent(MainActivity.this, NumbersActivity.class);
                Toast.makeText(MainActivity.this, "Open " + getResources().getString(R.string.category_numbers)
                        + " category", Toast.LENGTH_SHORT).show();
                startActivity(newActivity);
            }
        });

        phrasesTextView.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {

                Intent newActivity = new Intent(MainActivity.this, PhrasesActivity.class);
                Toast.makeText(MainActivity.this, "Open " + getResources().getString(R.string.category_phrases)
                        + " category", Toast.LENGTH_SHORT).show();
                startActivity(newActivity);
            }
        });

        familyTextView.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {

                Intent newActivity = new Intent(MainActivity.this, FamilyActivity.class);
                Toast.makeText(MainActivity.this, "Open " + getResources().getString(R.string.category_family)
                        + " category", Toast.LENGTH_SHORT).show();
                startActivity(newActivity);
            }
        });

        colorsTextView.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {

                Intent newActivity = new Intent(MainActivity.this, ColorsActivity.class);
                Toast.makeText(MainActivity.this, "Open " + getResources().getString(R.string.category_colors)
                        + " category", Toast.LENGTH_SHORT).show();
                startActivity(newActivity);
            }
        });
    }


}
