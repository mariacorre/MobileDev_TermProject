package com.MobileDevTermProj;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Forgot_Password extends AppCompatActivity {

    EditText txtpassword1, Txtpassword2;
    Button bSubmit;
    private static final String PREFER_NAME = "Reg";


    UserSession session;

    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        session = new UserSession(getApplicationContext());
        txtpassword1 = (EditText) findViewById(R.id.txtPassword1);
        Txtpassword2 = (EditText) findViewById(R.id.txtPassword2);


        bSubmit = (Button) findViewById(R.id.subButton);
        sharedPreferences = getApplicationContext().getSharedPreferences("Reg", 0);
        editor = sharedPreferences.edit();



        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String password1 = txtpassword1.getText().toString();
                String password2 = Txtpassword2.getText().toString();


                if(password1.equals(""))
                {
                    Toast.makeText(Forgot_Password.this, "Please type in password 1", Toast.LENGTH_SHORT).show();
                }

                else if ( password2.equals(""))
                {
                    Toast.makeText(Forgot_Password.this, "Please type in password 2", Toast.LENGTH_SHORT).show();
                }
                else if(!password1.equals(password2)){
                    Toast.makeText(Forgot_Password.this, "The password not matching", Toast.LENGTH_SHORT).show();

                }

                else{
                    editor.putString("txtPassword", password1);

                    editor.commit();

                    // after saving the value open next activity
                    Intent ob = new Intent(Forgot_Password.this, LoginActivity.class);
                    startActivity(ob);
                }

            }
        });




    }
}