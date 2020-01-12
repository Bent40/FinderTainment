package com.example.ronen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
//TODO
//SEND VARS
public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);
        CardView card_view = (CardView) findViewById(R.id.cardView);
        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ////////////////////////////////////////////////////////////////////////
                OkHttpClient client = new OkHttpClient();
                EditText username = (EditText)findViewById(R.id.editText);
                EditText password = (EditText)findViewById(R.id.editText2);

                RequestBody formBody = new FormBody.Builder()
                        .add("username", username.getText().toString())
                        .add("password", password.getText().toString())
                        .build();
                Request request = new Request.Builder()
                        .url("http://localhost:3000/register")// CHANGE!!!!!!!!!
                        .post(formBody)
                        .build();

                try {
                    Response response = client.newCall(request).execute();



                    // Do something with the response.
                } catch (IOException e) {
                    e.printStackTrace();


                }
                ////////////////////////////////////////////////////////////////////
                startActivity(new Intent(SignUp.this, MainActivity.class));

            }
        });

    }

}
