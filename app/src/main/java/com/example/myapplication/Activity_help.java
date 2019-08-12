package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_help extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }

    public void addquestion(View v){

        btn = findViewById(R.id.addQuestion);

        Intent intent = new Intent(Activity_help.this, Activity_add_question.class);
        startActivity(intent);
    }
}
