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
import android.widget.LinearLayout;
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


    // this instance of the Object Context stores the Activity
    // where we come from
    private Context context;

    // this variable stores the background color of the
    // respective category
    private int backgroundColorResourceId;

    /*
        Constructor
        @param: context - the activity to where the items in the list are going to be displayed
        @param: words - the data which is going to be displayed
     */
    public WordAdapter(Context context, ArrayList<Word> words, int backgroudColorResourceId){
        /*
            We pass all the data to the super constructor and we write the layout as 0 since we
            do not need it
         */
        super(context, 0, words);
        this.backgroundColorResourceId = backgroudColorResourceId;
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

        // Getting the values from the currentWord instance
        // Adding those values to the Views
        miwokTextView.setText(currentWord.getMiwokWord());
        englishTextView.setText(currentWord.getEnglishWord());

        // setting a new font
        Typeface fabricaTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/Fabrica.otf");
        miwokTextView.setTypeface(fabricaTypeface);
        englishTextView.setTypeface(fabricaTypeface);

        if(currentWord.isImageDefined()){
            /*
                Get the image ID if there is an
                image associated with this view
             */
            imageView.setImageResource(currentWord.getImageResourceId());
        } else {
            /*
                Otherwise set visibility of the
                ImageView to GONE so it will not
                take space
             */
            imageView.setVisibility(View.GONE);
        }

        /**
         * Set background on the Text Views Linear Layout
         */
        LinearLayout textViewsLinearLayout = (LinearLayout) listItemView.findViewById(R.id.list_item_textviews);
        textViewsLinearLayout.setBackgroundResource(backgroundColorResourceId);

        return listItemView;
    }
}
