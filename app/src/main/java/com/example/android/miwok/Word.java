package com.example.android.miwok;

/**
 * Created by terz99 on 3/15/17.
 */

public class Word {

    // miwokWord -> the word in Miwok, englishWord -> the word in English
    private String miwokWord, englishWord;

    /*
        Constructor
        @param: miwokWord - the word in Miwok
        @param: englishWord - the word in English
     */
    public Word(String englishWord, String miwokWord) {
        this.miwokWord = miwokWord;
        this.englishWord = englishWord;
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
}
