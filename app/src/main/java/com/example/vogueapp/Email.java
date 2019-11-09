package com.example.vogueapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends AppCompatActivity {

    private EditText met_em,met_cc,met_sub,met_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        met_em=findViewById(R.id.email);
        met_cc=findViewById(R.id.cc);
        met_sub=findViewById(R.id.subject);
        met_msg=findViewById(R.id.message);

        Button btns=findViewById(R.id.send);
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    private void sendEmail(){
        //stores in the string and intent to email action
        String Em =met_em.getText().toString();
        String [] toList=Em.split(",");
        String CC= met_cc.getText().toString();
        String[] ccList= CC.split(",");

        String sub=met_sub.getText().toString();
        String msg=met_msg.getText().toString();


        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,toList);
        intent.putExtra(Intent.EXTRA_CC,ccList);
        intent.putExtra(Intent.EXTRA_SUBJECT,sub);
        intent.putExtra(Intent.EXTRA_TEXT,msg);


        intent.setType("message/rfc822"); // Will open only email clients
        startActivity(Intent.createChooser(intent,"Choose an Email Application"));



    }
}
