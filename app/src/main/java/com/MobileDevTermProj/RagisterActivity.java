package com.MobileDevTermProj;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.IOException;

public class RagisterActivity extends Activity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button buttonReg2;
    EditText txtUsername, txtPassword, txtEmail,txtEnterSecurity;
    UserSession session;
    ImageView ivAddImages;
    private static final int CAMERA_REQUEST = 1888;
    private static final int Image_Capture_Code = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ragister);
        txtUsername = (EditText) findViewById(R.id.Name);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtEmail = (EditText) findViewById(R.id.Email);
        txtEnterSecurity = (EditText) findViewById(R.id.txtEnterSecurity);
        buttonReg2 = (Button) findViewById(R.id.buttonReg2);
        ivAddImages = (ImageView) findViewById(R.id.ivAddImages);

        ivAddImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CropImage.activity().start(RagisterActivity.this);
            }
        });



        sharedPreferences = getApplicationContext().getSharedPreferences("Reg", 0);
// get editor to edit in file
        editor = sharedPreferences.edit();

        buttonReg2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String name = txtUsername.getText().toString();
                String email = txtEmail.getText().toString();
                String pass = txtPassword.getText().toString();
                String code = txtEnterSecurity.getText().toString();

                if (name.equals("")) {
                    Toast.makeText(RagisterActivity.this, "Enter name", Toast.LENGTH_SHORT).show();
                } else if (code.equals("")) {
                    Toast.makeText(RagisterActivity.this, "Enter security code", Toast.LENGTH_SHORT).show();
                } else if (email.equals("")) {
                    Toast.makeText(RagisterActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
                } else if (pass.equals("")) {
                    Toast.makeText(RagisterActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                } else {

                    // as now we have information in string. Lets stored them with the help of editor
                    editor.putString("Name", name);
                    editor.putString("Code", code);
                    editor.putString("Email", email);
                    editor.putString("txtPassword", pass);
                    editor.putString("Profile", pass);

                    editor.commit();

                    // after saving the value open next activity
                    Intent ob = new Intent(RagisterActivity.this, LoginActivity.class);
                    startActivity(ob);
                }   // commit the values





            }
        });
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), resultUri);
                    Bitmap thumbnail = bitmap;//(BitmapFactory.decodeFile(picturePath));
                    thumbnail = Bitmap.createScaledBitmap(thumbnail, thumbnail.getWidth(), thumbnail.getHeight(), false);

                    Glide.with(RagisterActivity.this)
                            .load(resultUri)
                            .into(ivAddImages);

//                    photo = thumbnail;
                    ivAddImages.setImageBitmap(thumbnail);




                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {

                Exception error = result.getError();
            }

        }
    }




}