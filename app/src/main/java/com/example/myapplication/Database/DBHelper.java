package com.example.myapplication.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "BestPlace.db";

    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + Usermaster.SHOPE_TABLE + " (" +
                Usermaster.COLUMN_NAME_ID + " TEXT PRIMARY KEY," +
                Usermaster.COLUMN_NAME_SHOP + " TEXT," +
                Usermaster.COLUMN_NAME_COMPANY + " TEXT," +
                Usermaster.COLUMN_NAME_ADDRESS + " TEXT," +
                Usermaster.COLUMN_NAME_DISCRIPTION + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Usermaster.SHOPE_TABLE);
        onCreate(sqLiteDatabase);
    }
    public boolean add_shop(String id,String name,String company,String address,String discription){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Usermaster.COLUMN_NAME_ID,id);
        contentValues.put(Usermaster.COLUMN_NAME_SHOP,name);
        contentValues.put(Usermaster.COLUMN_NAME_COMPANY,company);
        contentValues.put(Usermaster.COLUMN_NAME_ADDRESS,address);
        contentValues.put(Usermaster.COLUMN_NAME_DISCRIPTION,discription);
        long insert = db.insert(Usermaster.SHOPE_TABLE, null, contentValues);
        if(insert == -1){
            return false;
        }else{
            return true;
        }

    }
}
