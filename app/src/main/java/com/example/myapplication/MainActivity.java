package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button srch,food,prf,reg,flt,slr,log,map,shop,UDFoods,UDShop,feed,prof;

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
        log = findViewById(R.id.login);
        map = findViewById(R.id.map);
        shop = findViewById(R.id.F_shop);
        UDFoods = findViewById(R.id.UDFoods);
        UDShop = findViewById(R.id.UDShop);
        feed = findViewById(R.id.feed);


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
                Intent redirect_reg = new Intent(MainActivity.this, register.class);
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


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirect_login = new Intent(MainActivity.this,log.class);
                startActivity(redirect_login);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirect_map = new Intent(MainActivity.this,maps.class);
                startActivity(redirect_map);
            }
        });


        slr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirect_sellr = new Intent(MainActivity.this,seller_profile.class);
                startActivity(redirect_sellr);
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirect_shop = new Intent(MainActivity.this,Add_Food_Shop.class);
                startActivity(redirect_shop);
            }
        });
        UDFoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirect_UDFoods = new Intent(MainActivity.this,Update_Delete_Food.class);
                startActivity(redirect_UDFoods);
            }
        });
        UDShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirect_UDShop = new Intent(MainActivity.this,Update_Delete_Shop.class);
                startActivity(redirect_UDShop);
            }
        });
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirect_feed = new Intent(MainActivity.this,Food_feed.class);
                startActivity(redirect_feed);
            }
        });



    }
}
