package com.example.myapplicationxo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView QuestionsXOTextView;
    TextView Question1TextView;
    Button trueX,falseO;
    Button ok;

    int score=0;
    int QuestionsXO =Answers.questions.length;
    int currentQuestion =0;
    String myAnswer ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QuestionsXOTextView = findViewById(R.id.QuestionsXO);
        Question1TextView = findViewById(R.id.Question1);
        trueX = findViewById(R.id.trueX);
        falseO = findViewById(R.id.false0);
        ok = findViewById(R.id.ok);

        trueX.setOnClickListener(this);
        falseO.setOnClickListener(this);
        ok.setOnClickListener(this);

        QuestionsXOTextView.setText("Total questions :"+QuestionsXO);
        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {
        trueX.setBackgroundColor(Color.WHITE);
        falseO.setBackgroundColor(Color.WHITE);
      Button clickedButton = (Button) view;
      if(clickedButton.getId()==R.id.ok){
        currentQuestion++;
        loadNewQuestion();
        if (myAnswer.equals(Answers.rightAnswers[currentQuestion])){
            score++;
        }
      }else{
          myAnswer = clickedButton.getText().toString();
          clickedButton.setBackgroundColor(Color.DKGRAY);
      }
    }
    void loadNewQuestion(){
        if (currentQuestion==QuestionsXO){
            return;
        }
      Question1TextView.setText(Answers.questions[currentQuestion]);
      trueX.setText(Answers.answers[currentQuestion][0]);
      falseO.setText(Answers.answers[currentQuestion][1]);
    }

}