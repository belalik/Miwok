package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // create an array of words

        //String[] words = new String[10];

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("father", "πατέρας", R.drawable.family_father));
        words.add(new Word("mother", "μητέρα", R.drawable.family_mother));
        words.add(new Word("son", "γιος", R.drawable.family_son));
        words.add(new Word("daughter", "κόρη", R.drawable.family_daughter));

        words.add(new Word("brother", "αδερφός", R.drawable.family_younger_brother));
        words.add(new Word("sister", "αδερφή", R.drawable.family_younger_sister));
        words.add(new Word("cousin-male", "ξάδερφος", R.drawable.family_older_brother));
        words.add(new Word("cousin-female", "ξαδέρφη", R.drawable.family_older_sister));

        words.add(new Word("grandfather", "παππούς", R.drawable.family_grandfather));
        words.add(new Word("grandmother", "γιαγιά", R.drawable.family_grandmother));


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
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);




        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_listyout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);



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
