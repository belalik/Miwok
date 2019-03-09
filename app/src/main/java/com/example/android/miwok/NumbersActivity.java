package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // create an array of words

        //String[] words = new String[10];

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("one", "ένα"));
        words.add(new Word("two", "δύο"));
        words.add(new Word("three", "τρία"));
        words.add(new Word("four", "τέσσερα"));

        words.add(new Word("five", "πέντε"));
        words.add(new Word("six", "έξι"));
        words.add(new Word("seven", "εφτά"));
        words.add(new Word("eight", "οχτώ"));

        words.add(new Word("nine", "εννιά"));
        words.add(new Word("ten", "δέκα"));


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

        ArrayAdapter<Word> itemsAdapter =
                new ArrayAdapter<Word>(this, R.layout.list_item, words);


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.

        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.

        listView.setAdapter(itemsAdapter);



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
}
