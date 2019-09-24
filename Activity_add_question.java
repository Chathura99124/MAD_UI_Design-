package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Database.Database;
import com.example.myapplication.Model.Question;

import java.util.ArrayList;
import java.util.List;

public class Activity_add_question extends AppCompatActivity {

    Spinner spinner;

    EditText descrptn;

    Button postQ,viewQ;

    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        spinner = (Spinner) findViewById(R.id.subjectSpinner);

        descrptn = (EditText) findViewById(R.id.questionDescription);

        postQ = (Button) findViewById(R.id.postQ);
        viewQ = (Button) findViewById(R.id.ViewQ);

        db = new Database(this);

        final List<String> list = new ArrayList<String>();

        list.add("Price");
        list.add("Foods");
        list.add("Location");
        list.add("Offers");
        list.add("Others");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        viewQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_add_question.this, Activity_unanswered_questions.class));
            }
        });

        postQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Question qstn = new Question();

                qstn.setSubject(Integer.toString(spinner.getSelectedItemPosition()));
                qstn.setQuestion(descrptn.getText().toString());

                if (!(spinner.getSelectedItem().toString().equals("")&&descrptn.getText().toString().equals(""))){
                    boolean isInserted = db.insert_question(qstn);
                    if (isInserted) {
                        spinner  .setSelection(0);
                        descrptn.setText("");
                        Toast.makeText(Activity_add_question.this,"Question Add Successful!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Activity_add_question.this,"Data is not inserted", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(Activity_add_question.this,"Required !", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
