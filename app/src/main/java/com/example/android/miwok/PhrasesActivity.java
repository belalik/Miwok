package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    MediaPlayer mp;
    ArrayList<Word> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        //ArrayList<Word> words = new ArrayList<Word>();

        words = new ArrayList<Word>();

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
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);




        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(view.getContext(), "CLICKED THIS ... "+i, Toast.LENGTH_SHORT).show();

                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                if (words.get(i).hasAudio()) {
                    //Toast.makeText(view.getContext(), "IN HERE "+i, Toast.LENGTH_SHORT).show();
                    mp = MediaPlayer.create(getApplicationContext(), words.get(i).getAudioResourceID());
                    //mp = MediaPlayer.create(getApplicationContext(), R.raw.number1);
                    mp.start();


                }

            }
        });



    }
}
