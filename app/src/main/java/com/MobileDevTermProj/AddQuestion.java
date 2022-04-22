package com.MobileDevTermProj;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.MobileDevTermProj.R;


public class AddQuestion extends AppCompatActivity {
    EditText questionOne,answerOne,choiceOne,choiceTwo,choiceThree;
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);

        questionOne = findViewById(R.id.questionOne);
        answerOne = findViewById(R.id.answerOne);
        choiceOne = findViewById(R.id.choiceOne);
        choiceTwo = findViewById(R.id.choiceThree);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper myDB = new DBHelper(AddQuestion.this);
                myDB.insertQuestion(questionOne.getText().toString().trim(),
                        answerOne.getText().toString().trim(),
                        choiceOne.getText().toString().trim(),
                        choiceTwo.getText().toString().trim(),
                        choiceThree.getText().toString().trim());
            }
        });
    }
}
