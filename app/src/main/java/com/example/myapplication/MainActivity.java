package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button srch,food,prf,reg,flt,slr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        srch = findViewById(R.id.srch);
        food = findViewById(R.id.food);
        prf = findViewById(R.id.viwe_profile);
        reg = findViewById(R.id.reg);
        flt = findViewById(R.id.filter);
        slr = findViewById(R.id.seller);

        srch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirect_srch = new Intent(MainActivity.this,search.class);
                startActivity(redirect_srch);
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirect_food = new Intent(MainActivity.this,Add_Foods.class);
                startActivity(redirect_food);

            }
        });

        prf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirect_profile = new Intent(MainActivity.this,User.class);
                startActivity(redirect_profile);
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirect_reg = new Intent(MainActivity.this,login.class);
                startActivity(redirect_reg);

            }
        });

        flt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirect_filter = new Intent(MainActivity.this,Filter.class);
                startActivity(redirect_filter);

            }
        });

        slr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirect_seller = new Intent(MainActivity.this,seller_profile.class);
                startActivity(redirect_seller);
            }
        });

    }
}
