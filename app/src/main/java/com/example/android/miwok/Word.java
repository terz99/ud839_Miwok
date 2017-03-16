package com.example.android.miwok;

/**
 * Created by terz99 on 3/15/17.
 */

public class Word {

    // constant value for not defined views and objects
    private static final int NOT_DEFINED = -1;
    // miwokWord -> the word in Miwok, englishWord -> the word in English
    private String miwokWord, englishWord;
    private int imageResourceId, backgroundColorId;

    /*
        Constructor
        @param: miwokWord - the word in Miwok
        @param: englishWord - the word in English
        @param: imageResourceId - the ID from the image resource from java R class
    */
    public Word(String englishWord, String miwokWord, int imageResourceId, int backgroundColorId) {
        this.miwokWord = miwokWord;
        this.imageResourceId = imageResourceId;
        this.englishWord = englishWord;
        this.backgroundColorId = backgroundColorId;
    }



    // returns the word in Miwok
    public String getMiwokWord() {
        return miwokWord;
    }

    // sets another value for the word in Miwok Language
    public void setMiwokWord(String miwokWord) {
        this.miwokWord = miwokWord;
    }

    // returns the word in English Language
    public String getEnglishWord() {
        return englishWord;
    }

    // sets another value for the word in English
    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public boolean isImageDefined() {
        return (imageResourceId != NOT_DEFINED);
    }

    public int getBackgroundColorId() {
        return backgroundColorId;
    }

    public void setBackgroundColorId(int backgroundColorId) {
        this.backgroundColorId = backgroundColorId;
    }
}
