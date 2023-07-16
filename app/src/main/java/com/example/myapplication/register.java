package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button regis = (Button) findViewById(R.id.button6);
        EditText userid = (EditText) findViewById(R.id.edit1);
        EditText name = (EditText) findViewById(R.id.edit5);
        TextView registertext=(TextView) findViewById(R.id.textView12);
        EditText pass =(EditText) findViewById(R.id.edit4);
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserEntity ente = new UserEntity();
                ente.setUserid(userid.getText().toString());
                ente.setName(name.getText().toString());

                ente.setPassword(pass.getText().toString());
                  if(validateinput(ente)) {
                      UserDatabase userDatabase = UserDatabase.getUserdatabase(getApplicationContext());
                      final UserDao us = userDatabase.userDao();

                      new Thread(new Runnable() {
                          @Override
                          public void run() {
                              us.RegisterUser(ente);

                              runOnUiThread(new Runnable() {
                                  @Override
                                  public void run() {
                                      registertext.setText("succesfully registered");
                                  }
                              });

                          }
                      }).start();

                  }
                  else
                  {
                      registertext.setText("illegal input");
                  }

            }

        });

    }


    public  boolean validateinput(UserEntity entity)
    {
        if(entity.getName().isEmpty()||entity.getPassword().isEmpty()||entity.getUserid().isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    }







