package com.example.zzz.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Datebase extends SQLiteOpenHelper {
    private static final String DBName = "DailyCalorie.db";
    private static final String CALORIE = "Caloriejilu";

    private static final String CREATE_CALORIE_TABLE
            ="create table " + CALORIE + "(id integer primary key autoincrement, time text,calorie text)";

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CALORIE_TABLE);
    }

    public Datebase(Context context, int version) {
    super(context, DBName, null, version);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            switch (oldVersion){
                case 1:
                    break;
                default:
                    break;

            }

    }
}
