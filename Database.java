package com.example.myapplication.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.Model.Question;

import java.util.ArrayList;


public class Database extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "mad.db";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table question(ID INTEGER PRIMARY KEY AUTOINCREMENT,subject text,question text)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<Question> readAllQuestion(){

        ArrayList<Question> models= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor results = db.rawQuery("select * from question",null);
        results.moveToFirst();

        while (results.isAfterLast()==false){

            Question model= new Question();

            model.setId(results.getInt(0));
            models.add(model);
            results.moveToNext();

        }

        return models;

    }

    public ArrayList<Question> selectedQuestion(String id){

        ArrayList<Question> models= new ArrayList<>();
        SQLiteDatabase scoredb = this.getReadableDatabase();
        Cursor results = scoredb.rawQuery("select * from question where id='"+id+"'",null);
        results.moveToFirst();

        while (results.isAfterLast()==false){

            Question model= new Question();
            model.setSubject(results.getString(1));
            model.setQuestion(results.getString(2));
            models.add(model);
            results.moveToNext();

        }

        return models;
    }

    public boolean updateQuestion(Question question){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("subject",question.getSubject());
        contentValues.put("question",question.getQuestion());

        long res=db.update("question",contentValues,"id='"+question.getId()+"'",null);

        if(res==-1){
            return false;
        }else{
            return true;
        }

    }

    public boolean deleteQuestion(String id){

        SQLiteDatabase db = getReadableDatabase();

        long res=db.delete("question","id='"+id+"'", null);

        db.close();

        if(res==-1){
            return false;
        }else{
            return true;
        }

    }

    public boolean insert_question(Question question) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("subject",question.getSubject());
        contentValues.put("question",question.getQuestion());

        long result = db.insert("question",null,contentValues);
        if (result == -1) {
            return false;
        }
        else {
            return true;
        }

    }

}

