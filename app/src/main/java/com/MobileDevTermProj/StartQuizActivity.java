package com.MobileDevTermProj;

import static com.MobileDevTermProj.UserSession.PREFER_NAME;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class StartQuizActivity extends Activity {
    private Button btnNext;
    private UserSession session;
    private TextView welcomeUser, starQuizQuestion;
    private SharedPreferences sharedPreferences;
    private Random random;
    private RadioButton radiobtnOne, radiobtnTwo, radiobtnThree;
    private RadioGroup choices;
    private List<Question> questionList;
    private int score, questionCounter;
    private String answer;
    private Question question;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);

        session = new UserSession(getApplicationContext());

        sharedPreferences = getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);
        String uName = sharedPreferences.getString("Name", "");

        welcomeUser = findViewById(R.id.welcomeUser);
        welcomeUser.setText(welcomeUser.getText() + uName);

        starQuizQuestion = findViewById(R.id.starQuizQuestion);
        radiobtnOne = findViewById(R.id.radiobtnOne);
        radiobtnTwo = findViewById(R.id.radiobtnTwo);
        radiobtnThree = findViewById(R.id.radiobtnThree);
        choices = findViewById(R.id.choices);

        questionList = getAllQuestions();
        random = new Random();

        question = nextQuestion(random.nextInt(questionList.size()));
        setFields(question);
        questionCounter++;

        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionCounter < 3) {
                    if (answer.equalsIgnoreCase(question.getAnswer())) {
                        score++;
                    }
                    choices.clearCheck();
                    question = nextQuestion(random.nextInt(questionList.size()));
                    setFields(question);
                    questionCounter++;
                } else if (questionCounter == 3) {
                    if (answer.equalsIgnoreCase(question.getAnswer())) {
                        score++;
                    }
                    Toast.makeText(getApplicationContext(),
                            "Result: " + score,
                            Toast.LENGTH_LONG).show();

                    editor = sharedPreferences.edit();
                    editor.putString("finalScore", String.valueOf(score));
                    editor.commit();

                    Intent i = new Intent(getApplicationContext(), ResultActivity.class);

                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);

                    finish();
                }
            }
        });

        choices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                if (radioButton != null) {
                    answer = radioButton.getText().toString();
                }
            }
        });
    }

    private List<Question> getAllQuestions() {
        DBHelper myDB = new DBHelper(StartQuizActivity.this);
        return myDB.getAllQuestions();
    }

    private Question nextQuestion(int num) {
        return questionList.get(num);
    }

    private void setFields(Question q) {
        starQuizQuestion.setText("Question " + (questionCounter + 1) + "/3: \n" + q.getQuestion());
        radiobtnOne.setText(q.getChoice1());
        radiobtnTwo.setText(q.getChoice2());
        radiobtnThree.setText(q.getChoice3());
    }
}
