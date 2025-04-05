package com.example.onlineassessment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WonActivity extends AppCompatActivity {

    CircularProgressBar circularProgressBar;
    TextView resultText;
    int correct, wrong;
    LinearLayout btnShare;
    ImageView exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        correct = getIntent().getIntExtra("correct", 0);
        wrong = getIntent().getIntExtra("wrong", 0);

        circularProgressBar = findViewById(R.id.circularProgressBar);
        resultText = findViewById(R.id.resultText);
        btnShare = findViewById(R.id.btnShare);
        exit = findViewById(R.id.exit);

        circularProgressBar.setProgress(correct);
        DashboardActivity dashboardActivity = new DashboardActivity();
        circularProgressBar.setProgressMax(dashboardActivity.getIndex()+1);

        resultText.setText(correct + "/" + (dashboardActivity.getIndex() + 1));

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                DashboardActivity.setIndex(0);
                Intent intent = new Intent(WonActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
                    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
                    String date = dateFormat.format(cal.getTime());
                    String time = timeFormat.format(cal.getTime());

                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage = "\nI got " + correct + " out of " + (dashboardActivity.getIndex() + 1) + " in Online Assessment on " + date + " at " + time;
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch (Exception e) {
                    //e.toString();
                }
            }
        });
    }
}