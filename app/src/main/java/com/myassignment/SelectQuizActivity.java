package com.myassignment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectQuizActivity extends AppCompatActivity {
    Button buttonCreateQuiz, buttonStartQuiz;
    UserSession session;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_options);

        buttonCreateQuiz = (Button) findViewById(R.id.buttonCreateQuiz);
        buttonCreateQuiz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new  Intent(getApplicationContext(),CreateQuizActivity.class);
//                        Intent i = new Intent(getApplicationContext(), MainActivity.class);

                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);

                finish();
            }
        });

        buttonStartQuiz = (Button) findViewById(R.id.buttonStartQuiz);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new  Intent(getApplicationContext(),CreateQuizActivity.class);
//                        Intent i = new Intent(getApplicationContext(), MainActivity.class);

                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);

                finish();
            }
        });
    }
}
