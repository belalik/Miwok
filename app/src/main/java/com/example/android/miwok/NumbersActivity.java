package com.example.android.miwok;


import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mp;
    //private ArrayList<Word> words;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        //ArrayList<Word> words = new ArrayList<Word>();

        /**
         * Needs to be declared final in order to be accessible by the anonymous class
         * which overrides (defines) the onItemClick method, below.  Before it was
         * initialized as a Global variable in the NumbersActivity class (outside of onCreate - code now in comments).
         */
        final ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("one", "ένα", R.drawable.number_one, R.raw.number1));
        words.add(new Word("two", "δύο", R.drawable.number_two, R.raw.number2));
        words.add(new Word("three", "τρία", R.drawable.number_three, R.raw.number3));
        words.add(new Word("four", "τέσσερα", R.drawable.number_four, R.raw.number4));

        words.add(new Word("five", "πέντε", R.drawable.number_five));
        words.add(new Word("six", "έξι", R.drawable.number_six));
        words.add(new Word("seven", "εφτά", R.drawable.number_seven));
        words.add(new Word("eight", "οχτώ", R.drawable.number_eight));

        words.add(new Word("nine", "εννιά", R.drawable.number_nine));
        words.add(new Word("ten", "δέκα", R.drawable.number_ten));


        // Log.v("NumbersActivity", "word at ArrayList index 9 is: " + words.get(9));

        // find the root view of the whole layout
        //LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        /*
        // GridView code:

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);


        GridView gridView = (GridView) findViewById(R.id.grid_view);

        gridView.setAdapter(itemsAdapter);
        */


        // ListView code

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_listyout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(view.getContext(), "CLICKED THIS ... "+i, Toast.LENGTH_SHORT).show();
                Log.v("NumbersActivity", "Current word at position " + i + " is " + words.get(i).toString());

                /**
                 * old code - still used in PhrasesActivity - kept it here for education purposes.
                 * Functionality replaced by 'helper' method ..
                 */

                /**
                 if (mp != null) {
                 mp.stop();
                 mp.release();
                 mp = null;
                 }
                 */

                if (words.get(i).hasAudio()) {

                    /**
                     * (Also) Release before a new audio file is loaded.
                     */
                    releaseMediaPlayer();
                    //mp = MediaPlayer.create(getApplicationContext(), words.get(i).getAudioResourceID());

                    // different way to pass the context
                    mp = MediaPlayer.create(NumbersActivity.this, words.get(i).getAudioResourceID());
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
        });

    }

    @Override
    protected void onStop() {
        super.onStop();

        // When the activity is stopped, release the MediaPlayer resources because we won't be
        // playing any more sounds.
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
        }
    }


    /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, R.raw.number_one);
                mMediaPlayer.start();
            }
        });

         */

        /*{
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(MainActivity.this, SendMessage.class);
                String message = "abc";
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });*/

        /*
        * old block code with for-loop
        * created separate TextView for each word
        *
        * for (int i = 0; i < words.size(); i++) {
            // create a new textView
            TextView wordView = new TextView(this);

            // set the text to be the word at the current index
            wordView.setText(words.get(i));

            // Add this textView as another child to the root view of this layout
            rootView.addView(wordView);
        }*/
}
