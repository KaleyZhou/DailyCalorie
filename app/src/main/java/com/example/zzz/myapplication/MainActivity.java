package com.example.zzz.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Calendar cal;
    private int year,month,day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);

        getData();

    }

    public void bianji(View view) {
        Intent intent = new Intent(MainActivity.this,calorie02.class);
        startActivityForResult(intent,1);
    }
    public void getData(){
        cal=Calendar.getInstance();
        year=cal.get(Calendar.YEAR);
        month=cal.get(Calendar.MONTH);
        day=cal.get(Calendar.DAY_OF_MONTH);

    }

    public void choose1(View view) {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                TextView start=(TextView)findViewById(R.id.starday);
                start.setText(year+"-"+(++month)+"-"+dayOfMonth);
            }
        };
        DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,0, listener,year,month,day);
        dialog.show();

    }
    public void choose2(View view) {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                TextView stop=(TextView)findViewById(R.id.stopday);
                stop.setText(year+"-"+(++month)+"-"+dayOfMonth);
            }
        };
        DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,0, listener,year,month,day);
        dialog.show();

    }
}
