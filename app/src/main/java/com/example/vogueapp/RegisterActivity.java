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

public class RegisterActivity extends AppCompatActivity {
private Button creatbtn;
private EditText  useremail,userpassword;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        creatbtn = (Button) findViewById(R.id.register_btn);

        useremail = (EditText) findViewById(R.id.regemail);
        userpassword = (EditText) findViewById(R.id.regpass);
        creatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userRegister();
            }

        });
        firebaseAuth=FirebaseAuth.getInstance();


    }

    public void userRegister()
    {
        //method for registration

        String email= useremail.getText().toString().trim();
        String pass = userpassword.getText().toString().trim();


        if (TextUtils.isEmpty(email))
        {
            Toast.makeText(getApplicationContext(),"Enter email",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass))
        {
            Toast.makeText(getApplicationContext(),"Enter password",Toast.LENGTH_SHORT).show();
            return;
        }


        firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
//firebase authentication for refistering with email and password
                if(task.isSuccessful())
                {
                    finish();
                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                    Toast.makeText(getApplicationContext(),"Registration Successful",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Registration UNSuccessful",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



}
