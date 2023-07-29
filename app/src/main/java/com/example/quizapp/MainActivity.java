package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView total_ques, ques, ques_no;
    Button ansA, ansB, ansC, ansD, submit;

    int score = 0, count = 0;
    int tot_count = QuesAns.question.length;
    int currQuesIndex = getRandomValue(0,tot_count);
    String selAns = "";

    HashSet<Integer> set = new HashSet<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total_ques = findViewById(R.id.total_ques);
        ques = findViewById(R.id.ques_no);
        ques_no = findViewById(R.id.no_ques);

        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);

        submit = findViewById(R.id.submit_btn);
        submit.setOnClickListener(this);

        total_ques.setText("Total Number of Questions : " + 5);

        loadQues();
    }

    private void loadQues() {

        if(count == 5){
            finishQuiz();
            return;
        }

        int no = count+1;
        ques_no.setText("Question " + no + " :-");
        ques.setText(QuesAns.question[currQuesIndex]);
        ansA.setText(QuesAns.choices[currQuesIndex][0]);
        ansB.setText(QuesAns.choices[currQuesIndex][1]);
        ansC.setText(QuesAns.choices[currQuesIndex][2]);
        ansD.setText(QuesAns.choices[currQuesIndex][3]);
    }

    private void finishQuiz() {
        String passRes = "";
        if(score > 5 * 0.6) passRes = "Passed";
        else passRes = "Failed";

        new AlertDialog.Builder(this)
                .setTitle(passRes).setMessage("Score is " + score + " Out of 5")
                .setPositiveButton("Restart", ((dialogInterface, i) -> restartQuiz()))
                .setCancelable(false)
                .show();
    }

    private void restartQuiz() {
        score = 0;
        count = 0;
        currQuesIndex = getRandomValue(0,tot_count);
        loadQues();
    }

    @Override
    public void onClick(View view) {
        Button clickedBtn = (Button) view;

        ansA.setBackgroundColor(Color.WHITE);
        ansA.setTextColor(Color.BLACK);
        ansB.setBackgroundColor(Color.WHITE);
        ansB.setTextColor(Color.BLACK);
        ansC.setBackgroundColor(Color.WHITE);
        ansC.setTextColor(Color.BLACK);
        ansD.setBackgroundColor(Color.WHITE);
        ansD.setTextColor(Color.BLACK);

        if(clickedBtn.getId() == R.id.submit_btn){
            if(selAns.equals(QuesAns.ans[currQuesIndex])){
                score += 1;
            }
            currQuesIndex = getRandomValue(0,tot_count);
            count++;
            loadQues();
        }else{
            // Choice btn is Clicked, change the color of choice being selected.
            selAns = clickedBtn.getText().toString();
            clickedBtn.setBackgroundColor(Color.BLACK);
            clickedBtn.setTextColor(Color.WHITE);
        }
    }
    public static int getRandomValue(int Min, int Max)
    {

        // Get and return the random integer
        // within Min and Max
        return ThreadLocalRandom
                .current()
                .nextInt(Min, Max + 1);
    }
}