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
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {

        // create the MainActivity layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the viewpager
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        // declare a new adapter for the viewpager
        CategoryAdapter pagerAdapter = new CategoryAdapter(getSupportFragmentManager());
        // set the adapter to the viewpager
        viewPager.setAdapter(pagerAdapter);
        // get the tabLayout resource
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        // set tabLayout in sync with the viewpager
        tabLayout.setupWithViewPager(viewPager);
    }


}
