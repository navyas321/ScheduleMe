package com.scheduler.android.scheduleme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ScheduleActivity extends AppCompatActivity {
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        mListView = (ListView) findViewById(R.id.scheduleView);
        mListView.setAdapter(new ScheduleAdapter());
    }
}
