package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

public class Activity_unanswered_questions extends AppCompatActivity {

    Database db;

    Spinner spinner,spinner2;

    EditText Description;

    Button edit,delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unanswered_questions);

        spinner = (Spinner) findViewById(R.id.SpinnerQedit);
        spinner2 = (Spinner) findViewById(R.id.subjectSpinner2);

        final List<String> list = new ArrayList<String>();

        list.add("Price");
        list.add("Foods");
        list.add("Location");
        list.add("Offers");
        list.add("Others");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);

        Description = (EditText) findViewById(R.id.questionsDescription);

        edit = (Button) findViewById(R.id.editQs);
        delete = (Button) findViewById(R.id.deleteQs);

        db = new Database(this);

        ArrayList<Question> allModels1 = db.readAllQuestion();

        final List<String> list1 = new ArrayList<String>();

        for(int i=0;allModels1.size()>i;i++){

            list1.add(Integer.toString(allModels1.get(i).getId()));

        }

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<Question> allModels = db.selectedQuestion(spinner.getSelectedItem().toString());

                for(int x=0;allModels.size()>x;x++){

                    spinner2.setSelection(Integer.parseInt(allModels.get(x).getSubject()));
                    Description.setText(allModels.get(x).getQuestion());

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question qstn = new Question();

                qstn.setId(Integer.parseInt(spinner.getSelectedItem().toString()));
                qstn.setSubject(Integer.toString(spinner2.getSelectedItemPosition()));
                qstn.setQuestion(Description.getText().toString());

                if (!(spinner2.getSelectedItem().toString().equals("")&&Description.getText().toString().equals(""))){
                    boolean isInserted = db.updateQuestion(qstn);
                    if (isInserted) {
                        spinner2.setSelection(0);
                        Description.setText("");
                        Toast.makeText(Activity_unanswered_questions.this,"Question Edit Successful!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Activity_unanswered_questions.this,"Data is not inserted", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(Activity_unanswered_questions.this,"Required !", Toast.LENGTH_LONG).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(spinner.getSelectedItem().toString().equals(""))){
                    boolean isInserted = db.deleteQuestion(spinner.getSelectedItem().toString());
                    if (isInserted) {
                        spinner2.setSelection(0);
                        Description.setText("");
                        Toast.makeText(Activity_unanswered_questions.this,"Question Delete Successful!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Activity_unanswered_questions.this,"Data is not inserted", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(Activity_unanswered_questions.this,"Required !", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
