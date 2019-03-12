package com.example.android.miwok;

/**
 * Represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation of that word.
 */
public class Word {

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Constant value that represents no audio was provided for this word
     */
    private static final int NO_AUDIO_PROVIDED = -1;

    /**
     * the (int) resource ID for the audio associated with that word.
     * <p>
     * Initially set to be equal to NO_AUDIO_PROVIDED - in order for method hasAudio to check.
     */
    private int mAudioResourceID = NO_AUDIO_PROVIDED;

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

    /**
     * Another constructor, again with three arguments, but this time WITH audio but NO image associated
     *
     * @param audioResourceID    audio resource id
     * @param defaultTranslation default translation
     * @param miwokTranslation   miwok (greek) translation
     */
    public Word(int audioResourceID, String defaultTranslation, String miwokTranslation) {
        mAudioResourceID = audioResourceID;
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }


    /**
     * Constructor that accepts four arguments
     *
     * @param defaultTranslation default translation
     * @param miwokTranslation   miwok (greek) translation
     * @param imageResourceID    image for the word
     * @param audioResourceID    audio for the word
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceID, int audioResourceID) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceID = imageResourceID;
        mAudioResourceID = audioResourceID;
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
     * Get the audio resource id
     *
     * @return int representing audio resource ID.
     */
    public int getAudioResourceID() {
        return mAudioResourceID;
    }

    /**
     * Return a boolean, indicating whether or not the word object has an image associated with it.
     */
    public boolean hasImage() {

        // if mImageResource is NOT EQUAL to NO_IMAGE_PROVIDED, then we have an image, hence return TRUE.
        return (mImageResourceID != NO_IMAGE_PROVIDED);
    }

    /**
     * Return a boolean, indicating whether or not the word object has an audio clip associated with it.
     */
    public boolean hasAudio() {

        // if mImageResource is NOT EQUAL to NO_IMAGE_PROVIDED, then we have an image, hence return TRUE.
        return (mAudioResourceID != NO_AUDIO_PROVIDED);
    }

    @Override
    public String toString() {
        return "Word{" +
                "mAudioResourceID=" + mAudioResourceID +
                ", mImageResourceID=" + mImageResourceID +
                ", mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                '}';
    }
}
