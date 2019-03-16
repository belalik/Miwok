package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends Fragment {

    private MediaPlayer mp;
    //private ArrayList<Word> words;

    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {

                        // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                        // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                        // our app is allowed to continue playing sound but at a lower volume. We'll treat
                        // both cases the same way because our app is playing short sound files.

                        // Pause playback and reset player to the start of the file. That way, we can
                        // play the word from the beginning when we resume playback.
                        mp.pause();
                        mp.seekTo(0);
                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {

                        // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                        mp.start();
                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {

                        // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                        // Stop playback and clean up resources
                        releaseMediaPlayer();
                    }
                }
            };

    /**
     * Initialize and 'instantiate' the mCompletionListener which implements an interface.
     * <p>
     * Its job is to become active when MediaPlayer's (mp) audio playing ends.
     * <p>
     * Then I call helper method to release() (and make MediaPlayer null, which I 'm not
     * 100% sure it's correct - due to multithreading issues and how that is handled in Android Oreo
     * and beyond.
     * <p>
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            //Toast.makeText(NumbersActivity.this, "Audio finished", Toast.LENGTH_SHORT).show();
            releaseMediaPlayer();
        }
    };

    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        /** TODO: Insert all the code from the PhrasesActivity’s onCreate() method after the setContentView method call */

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);


        /**
         * Needs to be declared final in order to be accessible by the anonymous class
         * which overrides (defines) the onItemClick method, below.  Before it was
         * initialized as a Global variable in the NumbersActivity class (outside of onCreate - code now in comments).
         */
        final ArrayList<Word> words = new ArrayList<>();

        words.add(new Word(R.raw.phrase_pos_paei, "how are you?", "πώς πάει;"));
        words.add(new Word(R.raw.phrase_ti_kaneis, "what are you doing?", "τι κάνεις;"));
        words.add(new Word(R.raw.phrase_kalimera, "good morning", "καλημέρα"));
        words.add(new Word(R.raw.phrase_pos_se_lene, "what is your name?", "Πώς σε λένε;"));

        words.add(new Word(R.raw.phrase_thelo_kafe, "I want coffee", "Θέλω καφέ"));
        words.add(new Word(R.raw.phrase_kalinixta, "Good night", "Καληνύχτα"));
        words.add(new Word(R.raw.phrase_site, "When will the site be ready?", "Πότε θα είναι έτοιμο το site?"));
        words.add(new Word(R.raw.phrase_fagito, "What food do we have today?", "Τι φαγητό έχει σήμερα?"));

        words.add(new Word(R.raw.phrase_ysterwn, "In retrospect", "Εκ των υστέρων"));
        words.add(new Word(R.raw.phrase_politismiko, "Culture shock", "Πολιτισμικό σοκ"));

        words.add(new Word(R.raw.phrase_malaka, "What do you want re malaka?", "Τι θέλεις ρε μαλάκα?"));

        words.add(new Word(R.raw.phrase_nobel, "Nobel Prize", "Βραβείο Νόμπελ"));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        //WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_phrases);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_listyout file.
        //ListView listView = (ListView) findViewById(R.id.list);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                if (words.get(i).hasAudio()) {

                    /**
                     * (Also) Release before a new audio file is loaded.
                     */
                    releaseMediaPlayer();

                    // *forMe* old way of getting context - left it here for personal documentation.
                    //mp = MediaPlayer.create(getApplicationContext(), words.get(i).getAudioResourceID());


                    // Request audio focus for playback
                    int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                            // Use the music stream.
                            AudioManager.STREAM_MUSIC,
                            // Request permanent focus.
                            AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                        // Start playback


                        //mp = MediaPlayer.create(NumbersActivity.this, words.get(i).getAudioResourceID());
                        mp = MediaPlayer.create(getActivity(), words.get(i).getAudioResourceID());

                        mp.start();

                        /**
                         * Used to have an anonymous class here but rather than instantiating it every time,
                         * it is now set as a global variable (look for mCompletionListener initialization)
                         * and it is used (passed on to MediaPlayer mp) here.
                         *
                         */
                        mp.setOnCompletionListener(mCompletionListener);
                    }

                }

            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();

        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mp != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mp.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mp = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}
