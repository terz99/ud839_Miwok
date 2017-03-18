package com.example.android.miwok;

/**
 * Created by terz99 on 3/15/17.
 */

public class Word {

    // constant value for not defined views and objects
    private static final int NOT_DEFINED = -1;

    // miwokWord -> the word in Miwok, englishWord -> the word in English
    private String miwokWord, englishWord;

    //
    private int imageResourceId, audioResourceId;

    /*
        Constructor
        @param: miwokWord - the word in Miwok
        @param: englishWord - the word in English
        @param: imageResourceId - the ID from the image resource from java R class
    */
    public Word(String englishWord, String miwokWord, int imageResourceId, int audioResourceId) {
        this.miwokWord = miwokWord;
        this.imageResourceId = imageResourceId;
        this.englishWord = englishWord;
        this.audioResourceId = audioResourceId;
    }

    /*
    Constructor
    @param: miwokWord - the word in Miwok
    @param: englishWord - the word in English
*/
    public Word(String englishWord, String miwokWord, int audioResourceId) {
        this.miwokWord = miwokWord;
        imageResourceId = NOT_DEFINED;
        this.englishWord = englishWord;
        this.audioResourceId = audioResourceId;
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

    // returns te ID of the image
    public int getImageResourceId() {
        return imageResourceId;
    }

    // sets the ID of the image
    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    // see if there is an image associated with this
    public boolean isImageDefined() {
        return (imageResourceId != NOT_DEFINED);
    }

    // returns the ID of the audio file
    public int getAudioResourceId() {
        return audioResourceId;
    }

    // sets a new value the audio file's ID
    public void setAudioResourceId(int audioResourceId) {
        this.audioResourceId = audioResourceId;
    }

    /**
     * Method used for debugging and printing Log messages
     * @return String - returns info about the current Word
     */
    public String toString(){
        return "Word{" +
                "englishWord='" + englishWord + '\'' +
                ", miwokWord='" + miwokWord + '\'' +
                ", imageResourceId=" + imageResourceId +
                ", audioResourceId=" + audioResourceId +
                "}";
    }
}
