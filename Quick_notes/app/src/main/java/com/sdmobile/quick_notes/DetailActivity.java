package com.sdmobile.quick_notes;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView detailTextView = findViewById(R.id.detailTextView);
        TextView dataNotesTextView = findViewById(R.id.Data_Notes);

        // Get the data passed from MainActivity
        String item = getIntent().getStringExtra("ITEM");

        // Set the data to the TextViews
        detailTextView.setText(R.string.content_label);
        dataNotesTextView.setText(item);
    }
}
