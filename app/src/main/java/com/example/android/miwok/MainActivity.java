/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows the numbers category
        TextView numbers = (TextView) findViewById(R.id.numbers);

        // Set a click listener on that View
        numbers.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                // Add a small toast
                Toast.makeText(view.getContext(), "Opening Numbers", Toast.LENGTH_SHORT).show();

                // Create a new intent to open the {@link NumbersActivity}
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numbersIntent);
            }
        });

        // Find the View that shows the colors category
        TextView colors = (TextView) findViewById(R.id.colors);

        // Set a click listener on that View
        colors.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View view) {
                // Add a small toast
                Toast.makeText(view.getContext(), "Opening Colors", Toast.LENGTH_SHORT).show();

                // Create the intent so that the correct activity will be initiated
                Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(colorsIntent);
            }
        });


        // Find the View that shows the numbers category
        TextView phrases = (TextView) findViewById(R.id.phrases);

        // Set a click listener on that View
        phrases.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the phrases View is clicked on.
            @Override
            public void onClick(View view) {
                // Add a small toast
                Toast.makeText(view.getContext(), "Opening Phrases", Toast.LENGTH_SHORT).show();

                // Create the intent so that the correct activity will be initiated
                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(phrasesIntent);
            }
        });


        // Find the View that shows the numbers category
        TextView family = (TextView) findViewById(R.id.family);

        // Set a click listener on that View
        family.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family members View is clicked on.
            @Override
            public void onClick(View view) {
                // Add a small toast
                Toast.makeText(view.getContext(), "Opening Family Members", Toast.LENGTH_SHORT).show();

                // Create the intent so that the correct activity will be initiated
                Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(familyIntent);
            }
        });


    }

}
