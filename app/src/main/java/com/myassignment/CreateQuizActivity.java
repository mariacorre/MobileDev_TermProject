package com.myassignment;

import static com.myassignment.UserSession.PREFER_NAME;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CreateQuizActivity extends Activity {
    Button buttonCreateQuiz;
    UserSession session;
    EditText questionOne, answerOne, choiceOne, choiceTwo, choiceThree;
    Button buttonAdd, buttonDone;


    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);

        session = new UserSession(getApplicationContext());

//        Toast.makeText(getApplicationContext(),
//                "User Login Status: " + session.isUserLoggedIn(),
//                Toast.LENGTH_LONG).show();

        sharedPreferences = getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);
        String uName = sharedPreferences.getString("Name", "");

        questionOne = findViewById(R.id.questionOne);
        answerOne = findViewById(R.id.answerOne);
        choiceOne = findViewById(R.id.choiceOne);
        choiceTwo = findViewById(R.id.choiceTwo);
        choiceThree = findViewById(R.id.choiceThree);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper myDB = new DBHelper(CreateQuizActivity.this);
                boolean result = myDB.insertQuestion(questionOne.getText().toString().trim(),
                        answerOne.getText().toString().trim(),
                        choiceOne.getText().toString().trim(),
                        choiceTwo.getText().toString().trim(),
                        choiceThree.getText().toString().trim());
                if (result) {
                    Toast.makeText(getApplicationContext(), "Saved Successfully", Toast.LENGTH_SHORT).show();
                    //clear fields

                    questionOne.setText(null);
                    answerOne.setText(null);
                    choiceOne.setText(null);
                    choiceTwo.setText(null);
                    choiceThree.setText(null);

                    questionOne.requestFocus();
                } else {
                    Toast.makeText(getApplicationContext(), "Error Encountered while Saving.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonDone = findViewById(R.id.buttonDone);
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SelectQuizActivity.class);

                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);

                finish();
            }
        });

    }
}
