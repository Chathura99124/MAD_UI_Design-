package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Database.DBHelper;

public class Add_Food_Shop extends AppCompatActivity {

    DBHelper myDB;
    EditText edit_id,edit_name,edit_cmpany,edit_address,edit_discription;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__food__shop);
        myDB = new DBHelper(this);

        edit_id = (findViewById(R.id.EDIT_ID));
        edit_name = (findViewById(R.id.EDIT_NAME));
        edit_cmpany = (findViewById(R.id.EDIT_COMPNAY));
        edit_address = (findViewById(R.id.EDIT_ADDRESS));
        edit_discription = (findViewById(R.id.EDIT_DISCRIPTION));

        add = findViewById(R.id.ADD_SHOP);

        AddShop();



    }
    public void AddShop(){
        add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted =  myDB.add_shop(edit_id.getText().toString(),
                                edit_name.getText().toString(),
                                edit_cmpany.getText().toString(),
                                edit_address.getText().toString(),
                                edit_discription.getText().toString());
                        if(isInserted == true){
                            Toast.makeText(Add_Food_Shop.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(Add_Food_Shop.this,"Error",Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );
    }
}
