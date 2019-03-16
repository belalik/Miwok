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
public class FamilyFragment extends Fragment {


    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);

        /** TODO: Insert all the code from the FamilyActivity’s onCreate() method after the setContentView method call */

        final ArrayList<Word> words = new ArrayList<>();

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

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_family);

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
