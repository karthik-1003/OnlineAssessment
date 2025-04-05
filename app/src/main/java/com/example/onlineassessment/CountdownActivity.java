package com.example.onlineassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.os.CountDownTimer;

import android.widget.TextView;

public class CountdownActivity extends AppCompatActivity {
    public int counter,a=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);
        final TextView counttime=findViewById(R.id.counttime);
        new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                counttime.setText(String.valueOf(a));
                a--;
                counter++;
            }
            @Override
            public void onFinish() {
                Intent intent = new Intent(CountdownActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        }.start();
    }
}