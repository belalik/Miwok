package com.example.android.miwok;

/**
 * Represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation of that word.
 */
public class Word {

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;


    /**
     * the (int) resource ID for the image associated with that word.
     *
     * Initially set to be equal to NO_IMAGE_PROVIDED - in order for method hasImage to check.
     */
    private int mImageResourceID = NO_IMAGE_PROVIDED;

    /**
     * Default translation for the word
     */
    private String mDefaultTranslation;

    /**
     * Miwok translation for the word
     */
    private String mMiwokTranslation;

    /**
     * Constructor that accepts only string variables for words (no image)
     *
     * @param defaultTranslation the default translation
     * @param miwokTranslation the miwok translation
     */
    public Word(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    /**
     * Constructor that accepts three incoming parameters (including one for image resource id)
     * @param defaultTranslation the default translation
     * @param miwokTranslation the miwok translation
     * @param imageResourceID the int for image resource id
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceID) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceID = imageResourceID;
    }


    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }


    /**
     *
     * @return the resource ID for the image associated with this word.
     */
    public int getImageResourceID() {
        return mImageResourceID;
    }

    /**
     * Return a boolean, indicating whether or not the word object has an image associated with it.
     */
    public boolean hasImage() {

        // if mImageResource is NOT EQUAL to NO_IMAGE_PROVIDED, then we have an image, hence return TRUE.
        return (mImageResourceID != NO_IMAGE_PROVIDED);


    }
}
