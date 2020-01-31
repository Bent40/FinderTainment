package com.example.ronen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class history_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_page);

        BusinessList bsList = new BusinessList();
        ListView onScreen = findViewById(R.id.histoArr);






    }
}
