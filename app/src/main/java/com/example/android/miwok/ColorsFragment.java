package com.example.android.miwok;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {


    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);

        /** TODO: Insert all the code from the FamilyActivity’s onCreate() method after the setContentView method call */

        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("red", "κόκκινο", R.drawable.color_red));
        words.add(new Word("green", "πράσινο", R.drawable.color_green));
        words.add(new Word("brown", "καφέ", R.drawable.color_brown));
        words.add(new Word("gray", "γκρίζο", R.drawable.color_gray));

        words.add(new Word("black", "μαύρο", R.drawable.color_black));
        words.add(new Word("white", "λευκό", R.drawable.color_white));
        words.add(new Word("orange", "πορτοκαλί", R.drawable.color_mustard_yellow));
        words.add(new Word("blue", "μπλε", R.drawable.color_dusty_yellow));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_listyout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);


        return rootView;

    }

}
