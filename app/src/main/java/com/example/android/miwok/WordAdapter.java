package com.example.android.miwok;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    /**
     * Resource ID of the color for the background for this list of words.
     */
    private int mColorResourceID;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param words A List of Word objects to display in a list
     * @param colorResourceID the color id to be set as a background color for this list of words.
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceID) {
        super(context, 0, words);
        mColorResourceID = colorResourceID;
    }



    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }



        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.english_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());


        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceID());

            // make sure the image is visible again. Seems to work without it, but left it here anyway..
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            // Hide (GONE - takes up no space in the layoyt) the ImageView since there is no image to show.
            imageView.setVisibility(View.GONE);
        }


        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);

        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceID);

        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // following code also works (instead of previous TWO lines).
        // but keeping previous, probably better for compatibility reasons ....
        //textContainer.setBackgroundResource(mColorResourceID);


        //listItemView.setBackgroundColor(backgroundColor);



        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;

        //return super.getView(position, convertView, parent);
    }
}
