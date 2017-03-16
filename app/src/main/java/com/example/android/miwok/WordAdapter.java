package com.example.android.miwok;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.res.Resources;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by terz99 on 3/15/17.
 */

public class WordAdapter extends ArrayAdapter<Word>{


    private Context context;

    /*
        Constructor
        @param: context - the activity to where the items in the list are going to be displayed
        @param: words - the data which is going to be displayed
     */
    public WordAdapter(Context context, ArrayList<Word> words){
        /*
            We pass all the data to the super constructor and we write the layout as 0 since we
            do not need it
         */
        super(context, 0, words);
        this.context = context;
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){
            /*
                Using view from the scrap views (reusable views)
             */
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        /*
            Finding the Views from the listItemView
         */
        Word currentWord = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_textview);
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english_textview);

        // setting a new font
        Typeface fabricaTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/Fabrica.otf");

        // Getting the values from the currentWord instance
        // Adding those values to the Views
        imageView.setImageResource(currentWord.getImageResourceId());
        miwokTextView.setText(currentWord.getMiwokWord());
        englishTextView.setText(currentWord.getEnglishWord());
        miwokTextView.setTypeface(fabricaTypeface);
        englishTextView.setTypeface(fabricaTypeface);

        return listItemView;
    }
}
