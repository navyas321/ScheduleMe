package com.scheduler.android.scheduleme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ImportantDatesActivity extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important_dates);

        mListView = (ListView) findViewById(R.id.impDatesView);
        mListView.setAdapter(new ImpDatesAdapter());
    }
}
