package com.selah.constitution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextUtils;
import android.util.Patterns;

public class Contact_us extends AppCompatActivity {
    EditText editTextTo, editTextsubject, editTextMessage;
    Button sendbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        editTextTo = findViewById(R.id.emailtext);
        editTextsubject = findViewById(R.id.subjecttext);
        editTextMessage = findViewById(R.id.messagetext);
        sendbutton = findViewById(R.id.sendbtn);

        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = editTextTo.getText().toString();
                String subject = editTextsubject.getText().toString();
                String message = editTextMessage.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client:"));
            }
        });
    }
    }