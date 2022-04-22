package com.MobileDevTermProj;

import static com.MobileDevTermProj.UserSession.PREFER_NAME;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ResultActivity extends Activity {
    Button buttonDone;
    TextView textViewScore;
    UserSession session;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        sharedPreferences = getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);
        String finalScore = sharedPreferences.getString("finalScore", "");

        textViewScore= findViewById(R.id.textViewScore);
        textViewScore.setText(finalScore + "/3");
        buttonDone = (Button) findViewById(R.id.btnResultDone);
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
