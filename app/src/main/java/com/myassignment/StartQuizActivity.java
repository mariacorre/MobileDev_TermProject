package com.myassignment;

import static com.myassignment.UserSession.PREFER_NAME;
import android.app.Activity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartQuizActivity extends Activity {
    Button buttonCreateQuiz;
    UserSession session;
    //private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);



        session = new UserSession(getApplicationContext());

//        Toast.makeText(getApplicationContext(),
//                "User Login Status: " + session.isUserLoggedIn(),
//                Toast.LENGTH_LONG).show();


       // sharedPreferences = getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);
        //String uName = sharedPreferences.getString("Name", "");



    }
}
