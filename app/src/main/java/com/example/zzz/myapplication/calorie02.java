package com.example.zzz.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.util.AndroidException;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class calorie02 extends Activity {
    ArrayList<String> list;
    private String liebiao;
    public ListView listview;
    private static Datebase dbHelper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calorie02);
        list = new ArrayList<String>();
        dbHelper=new Datebase(this,1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        final AlertDialog.Builder builder=new AlertDialog.Builder(calorie02.this);
        Cursor cursor = db.query("Caloriejilu",null,
                null,null,null,null,null);
        if (cursor.moveToFirst()){
            do {
                String time = cursor.getString(cursor.getColumnIndex("time"));
                String calorie = cursor.getString(cursor.getColumnIndex("calorie"));
                String jilu=time+":"+calorie;
                list.add(jilu);
            }while(cursor.moveToNext());
            Collections.sort(list);
            listview = (ListView) findViewById(R.id.listview);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(calorie02.this,
                    android.R.layout.simple_list_item_1,list);
            listview.setAdapter(adapter);
        }


    }

    public void tianjia(View view) {
        Intent intent = new Intent(calorie02.this,calorie03.class);
        startActivityForResult(intent,2);
    }

    protected void onActivityResult(int requestcode,int resultcode,Intent data){
        switch (requestcode){
            case 2:
                if (resultcode==RESULT_OK){
                    String returndeData = data.getStringExtra("date_return");
                    String returncalorie = data.getStringExtra("number_return");
                    liebiao=returndeData+":"+returncalorie;
                    Log.i("zzzzz",liebiao);
                    Log.i("asddf","0");
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    Log.i("asddf","1");
                    ContentValues values = new ContentValues();
                    Log.i("asddf","2");
                    values.put("time",returndeData);
                    Log.i("asddf","3");
                    values.put("calorie",returncalorie);
                    Log.i("asddf","4");
                    db.insert("Caloriejilu",null,values);
                    Log.i("asddf","5");
                    values.clear();

                    list.add(liebiao);
                    Collections.sort(list);
                    listview = (ListView) findViewById(R.id.listview);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                            calorie02.this,android.R.layout.simple_list_item_1,list);
                    listview.setAdapter(adapter);
                }
        }

    }

}
