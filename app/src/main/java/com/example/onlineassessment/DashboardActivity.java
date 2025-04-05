package com.example.onlineassessment;

import static com.example.onlineassessment.OptionsActivity.listOfQ;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Collections;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    int timerValue = 20;
    ProgressBar progressBar;

    List<Modelclass> allQuestionsList;
    Modelclass modelclass;


//    public static void setIndex(int index) {
//        DashboardActivity.index = index;
//    }
    public int getIndex() {
        return index;
    }

    static int index = 0;
    TextView question, optionA, optionB, optionC, optionD;
    CardView cardOA, cardOB, cardOC, cardOD;
    int correctCount = 0;
    int wrongCount = 0;
    ImageView close;
    LinearLayout nextBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        hooks();

        allQuestionsList = listOfQ;
        Collections.shuffle(allQuestionsList);
        modelclass = listOfQ.get(index);
        close = findViewById(R.id.close);

//        cardOA.setCardBackgroundColor(getResources().getColor(R.color.white));
//        cardOB.setCardBackgroundColor(getResources().getColor(R.color.white));
//        cardOC.setCardBackgroundColor(getResources().getColor(R.color.white));
//        cardOD.setCardBackgroundColor(getResources().getColor(R.color.white));

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, WonActivity.class);
                intent.putExtra("correct", correctCount);
                intent.putExtra("wrong", wrongCount);
                startActivity(intent);
            }
        });

        nextBtn.setClickable(false);

        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long l) {
                timerValue = timerValue - 1;
                progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                if (index <= listOfQ.size() - 1 && index < 4) {
                    index++;
                    modelclass = listOfQ.get(index);
                    resetColor();
                    setAllData();
                }
                else{
                    GameWon();
                }

            }
        }.start();

        setAllData();
    }

    public void enableButton() {
        cardOA.setClickable(true);
        cardOB.setClickable(true);
        cardOC.setClickable(true);
        cardOD.setClickable(true);
    }

    public void disableButton() {
        cardOA.setClickable(false);
        cardOB.setClickable(false);
        cardOC.setClickable(false);
        cardOD.setClickable(false);
    }

    public void resetColor() {
        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.white));
    }

    private void setAllData() {
        question.setText(modelclass.getQuestion());
        optionA.setText(modelclass.getoA());
        optionB.setText(modelclass.getoB());
        optionC.setText(modelclass.getoC());
        optionD.setText(modelclass.getoD());
        timerValue = 20;
        countDownTimer.cancel();
        countDownTimer.start();
        enableButton();
        nextBtn.setClickable(false);
    }

    private void hooks() {
        progressBar = findViewById(R.id.quiz_timer);
        question = findViewById(R.id.card_question);
        optionA = findViewById(R.id.card_optionA);
        optionB = findViewById(R.id.card_optionB);
        optionC = findViewById(R.id.card_optionC);
        optionD = findViewById(R.id.card_optionD);

        cardOA = findViewById(R.id.cardA);
        cardOB = findViewById(R.id.cardB);
        cardOC = findViewById(R.id.cardC);
        cardOD = findViewById(R.id.cardD);

        nextBtn = findViewById(R.id.nextBtn);
    }


    public void Correct(CardView cardView) {
        cardView.setBackgroundColor(getResources().getColor(R.color.green));
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++correctCount;
                if (index < (listOfQ.size() - 1) && index < 4) {
                    index++;
                    modelclass = listOfQ.get(index);
                    resetColor();
                    setAllData();
                } else {
                    GameWon();
                }


            }
        });


    }

    public void Wrong(CardView cardView) {
        cardView.setBackgroundColor(getResources().getColor(R.color.red));
        if(modelclass.getoA().equals(modelclass.getAns())){
            cardOA.setBackgroundColor(getResources().getColor(R.color.green));
        }
        else if(modelclass.getoB().equals(modelclass.getAns())){
            cardOB.setBackgroundColor(getResources().getColor(R.color.green));
        }
        else if(modelclass.getoC().equals(modelclass.getAns())){
            cardOC.setBackgroundColor(getResources().getColor(R.color.green));
        }
        else{
            cardOD.setBackgroundColor(getResources().getColor(R.color.green));
        }
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++wrongCount;
                if (index < (listOfQ.size() - 1) && index < 4) {
                    index++;
                    modelclass = listOfQ.get(index);
                    resetColor();
                    setAllData();
                } else {
                    GameWon();
                }

            }
        });


    }

    private void GameWon() {
        Intent intent = new Intent(DashboardActivity.this, WonActivity.class);
        intent.putExtra("correct", correctCount);
        intent.putExtra("wrong", wrongCount);
        startActivity(intent);

    }




    public void optionAClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if (modelclass.getoA().equals(modelclass.getAns())) {
            cardOA.setCardBackgroundColor(getResources().getColor(R.color.green));
            if (index <= listOfQ.size() - 1) {
                Correct(cardOA);
            } else {
                GameWon();
            }
        } else {
            Wrong(cardOA);
        }
    }

    public void optionBClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if (modelclass.getoB().equals(modelclass.getAns())) {
            cardOB.setCardBackgroundColor(getResources().getColor(R.color.green));
            if (index <= listOfQ.size() - 1) {
                Correct(cardOB);
            } else {
                GameWon();
            }
        } else {
            Wrong(cardOB);
        }
    }

    public void optionCClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if (modelclass.getoC().equals(modelclass.getAns())) {
            cardOC.setCardBackgroundColor(getResources().getColor(R.color.green));
            if (index <= listOfQ.size() - 1) {
                Correct(cardOC);
            } else {
                GameWon();
            }
        } else {
            Wrong(cardOC);
        }
    }

    public void optionDClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if (modelclass.getoD().equals(modelclass.getAns())) {
            cardOD.setCardBackgroundColor(getResources().getColor(R.color.green));
            if (index <= listOfQ.size() - 1) {
                Correct(cardOD);
            } else {
                GameWon();
            }
        } else {
            Wrong(cardOD);
        }
    }
}
