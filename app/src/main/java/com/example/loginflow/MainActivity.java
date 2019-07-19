package com.example.loginflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static TextView attempts;
    private static Button btn_login;
    int attempt_counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton();
    }

    public void loginButton(){
        username = (EditText)findViewById(R.id.name);
        password = (EditText)findViewById(R.id.pass);
        attempts = (TextView)findViewById(R.id.attempt_count);
        btn_login = (Button)findViewById(R.id.log_btn);

        attempts.setText(Integer.toString(attempt_counter));

        btn_login.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(username.getText().toString().equals("vicky") && password.getText().toString().equals("1234")){

                            Toast.makeText(MainActivity.this , "User and Password is correct", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(".User");
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(MainActivity.this , "User and Password is Incorrect", Toast.LENGTH_SHORT).show();

                            attempt_counter--;
                            attempts.setText(Integer.toString(attempt_counter));
                            if(attempt_counter == 0 ){
                                 btn_login.setEnabled(false);
                            }
                        }
                    }
                }
        );
    }


}
