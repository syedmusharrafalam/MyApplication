package com.example.musharraf.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogIn extends AppCompatActivity {
    Button btnLogin;
    EditText userName,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        userName=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        String name=userName.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if(name.isEmpty())
        {
            userName.setError("email is required");
            userName.requestFocus();
            return;
        }
        if(pass.isEmpty())
        {
            password.setError("password is required");
            password.requestFocus();
            return;
        }

        if(name.equals("admin")&&pass.equals("admin"))
        {
            startActivity(new Intent(LogIn.this, Welcome.class));
            userName.setText("");
            password.setText("");

        }
        else {
            startActivity(new Intent(LogIn.this,Error.class));
            finish();
        }

    }
}
