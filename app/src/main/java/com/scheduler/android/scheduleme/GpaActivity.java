package com.scheduler.android.scheduleme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class GpaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);

        ImageButton calculatorBtn = (ImageButton) findViewById(R.id.calculator);
        calculatorBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(GpaActivity.this, GpaCalculatorActivity.class);
                startActivity(intent);
            }
        });
    }
}
