package com.MobileDevTermProj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;


import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Question question = new Question();

    private String answer;
    //private int questionLength = question.questions.length;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onClick(View v) {
//
    }


}