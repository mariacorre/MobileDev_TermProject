package com.MobileDevTermProj;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {


    private static final String PREFER_NAME = "Reg";
    Button buttonLogin;
    EditText txtUsername, txtPassword;
    UserSession session;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button switchButton = (Button) findViewById(R.id.buttonReg);
        switchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RagisterActivity.class);
                startActivity(intent);

            }
        });


        session = new UserSession(getApplicationContext());
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

//        Toast.makeText(getApplicationContext(),
//                "User Login Status: " + session.isUserLoggedIn(),
//                Toast.LENGTH_LONG).show();


        // User Login button
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        sharedPreferences = getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);


        // Login button click event
        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                if (username.trim().length() > 0 && password.trim().length() > 0) {
                    String uName = null;
                    String uPassword = null;
                    if (sharedPreferences.contains("Email")) {
                        uName = sharedPreferences.getString("Email", "");

                    }

                    if (sharedPreferences.contains("txtPassword")) {
                        uPassword = sharedPreferences.getString("txtPassword", "");

                    }


                    if (username.equals(uName) && password.equals(uPassword)) {
                        session.createUserLoginSession(uName,
                                uPassword);

                        Intent i = new  Intent(getApplicationContext(),SelectQuizActivity.class);
//                        Intent i = new Intent(getApplicationContext(), MainActivity.class);

                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);

                        finish();

                    } else {

                        Toast.makeText(getApplicationContext(),
                                "Email/Password is incorrect",
                                Toast.LENGTH_LONG).show();
                    }
                } else {

                    // user didn't entered username or password
                    Toast.makeText(getApplicationContext(),
                            "Please enter email and password",
                            Toast.LENGTH_LONG).show();

                }

            }
        });
    }

}