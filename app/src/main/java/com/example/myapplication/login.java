package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText loginid = (EditText) findViewById(R.id.edit1);
        EditText passwor = (EditText) findViewById(R.id.edit4);
        TextView logintext =(TextView) findViewById(R.id.textView11);
        Button re = (Button) findViewById(R.id.button6);
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userid = loginid.getText().toString();

                final String password = passwor.getText().toString();
                UserDatabase userDatabases = UserDatabase.getUserdatabase(getApplicationContext());
                final UserDao use = userDatabases.userDao();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        UserEntity userEnti = use.login(userid,password);
                        if(userEnti == null)
                        {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    logintext.setText("wrong username or login");
                                }
                            });
                        }
                        else
                        {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Intent ise = new Intent(getApplicationContext(),FullscreenActivity.class);
                                    startActivity(ise);
                                }
                            });
                        }

                    }
                }).start();
            }
        });
    }
}