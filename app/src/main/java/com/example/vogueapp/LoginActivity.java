package com.example.vogueapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText useremail,userpassword;
    private Button loginbtn;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        useremail = (EditText) findViewById(R.id.loginemail);
        userpassword = (EditText) findViewById(R.id.loginpass);
        loginbtn= (Button) findViewById(R.id.login);
        firebaseAuth=FirebaseAuth.getInstance();
//get instance to use the firebase in whose application
        loginbtn.setOnClickListener(this);

    }

    public void userLogin()
    {
        //methrod used to login
        String email= useremail.getText().toString().trim();
        String pass= userpassword.getText().toString().trim();
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(getApplicationContext(),"Enter Email",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass))
        {
            Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_SHORT).show();
            return;
        }
//firebase authenticatin is done for login with email and password
        firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {

                if(task.isSuccessful()){
                    startActivity(new Intent(LoginActivity.this,ShopNav.class));
                    Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                    finish();

                }
                else {
                    Toast.makeText(getApplicationContext(),"Login UNSuccessful",Toast.LENGTH_SHORT).show();
                    finish();

                }

            }
        });

    }


@Override
    public void onClick(View view){
        userLogin();

}
}
