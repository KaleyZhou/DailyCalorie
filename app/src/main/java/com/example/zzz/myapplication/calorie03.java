package com.example.zzz.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.time.Month;
import java.time.Year;
import java.util.Calendar;

import javax.xml.transform.Result;

public class calorie03 extends Activity {
    private int year,month,day;
    private  String calorienumber;
    String mon="";
    String day2="";
    public String riqi;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Calendar cal = Calendar.getInstance();
        year=cal.get(Calendar.YEAR);
        month=cal.get(Calendar.MONTH)+1;
        day=cal.get(Calendar.DAY_OF_MONTH);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calorie03);
        calorienumber ="";
        riqi=Integer.toString(year)+"-"+Integer.toString(month)+"-"+Integer.toString(day);
        DatePicker date =(DatePicker) findViewById(R.id.Datepicker);
        date.init(year, month - 1, day, new DatePicker.OnDateChangedListener() {

            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                monthOfYear++;
                {if(monthOfYear<10)
                {
                    mon="0"+monthOfYear;
                }
                else{
                    mon=""+monthOfYear;
                }}
                {if(dayOfMonth<10)
                {
                    day2="0"+day;
                }
                else
                {
                    day2=""+day;
                }}
                riqi=Integer.toString(year)+"-"+mon+"-"+day2;


            }
        });

    }

    public void fanhui(View view) {
        EditText num = (EditText) findViewById(R.id.EditText);
        calorienumber=num.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("date_return",riqi);
        intent.putExtra("number_return",calorienumber);
        setResult(RESULT_OK,intent);
        finish();

    }

}
