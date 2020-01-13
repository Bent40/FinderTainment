package com.example.ronen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;


import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        CardView card_view = (CardView) findViewById(R.id.cardView);
        TextView text_view = (TextView) findViewById(R.id.textView2);
        TextView more_info = (TextView) findViewById(R.id.more_info);
        TextView guest_login = (TextView) findViewById(R.id.guest_login);





        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 ////////////////////////////////////////////////////////////////////////
                OkHttpClient client = new OkHttpClient();
                EditText username = findViewById(R.id.editText);
                EditText password = findViewById(R.id.editText2);
                Toast.makeText(MainActivity.this, "gay", Toast.LENGTH_SHORT).show();
                RequestBody formBody = new FormBody.Builder()
                        .add("username", username.getText().toString())
                        .add("password", password.getText().toString())
                        .build();
                Request request = new Request.Builder()
                        .url("http://192.168.20.1:5000/login")// CHANGE!!!!!!!!!
                        .post(formBody)
                        .build();

                try {
                    Response response = client.newCall(request).execute();

                    Toast.makeText(MainActivity.this, "sushi hayom", Toast.LENGTH_SHORT).show();
                    // Do something with the response.
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ////////////////////////////////////////////////////////////////////
            }
        });
        text_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUp.class));

            }
        });
        more_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MoreInfo.class));

            }
        });
        guest_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DashBoard.class));

            }
        });
    }

}
