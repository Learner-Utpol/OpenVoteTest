package com.example.openvotetest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView datePic,timePic;
    String amPm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        datePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateIn();

            }
        });

        timePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeCu();
            }
        });
    }

    private void timeCu() {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                if (hour >= 12){
                    amPm = "PM";
                }else {
                    amPm ="AM";
                }
                timePic.setText(hour +":"+minute+" "+amPm);

            }
        };

        Calendar mTime = Calendar.getInstance();
        int hour = mTime.get(Calendar.HOUR_OF_DAY);
        int minute = mTime.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,onTimeSetListener,hour,minute,false);
        timePickerDialog.show();


    }


    private void dateIn() {

        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {


            }
        };

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,onDateSetListener,year,month,day);

        String currentDateString = DateFormat.getDateInstance().format(calendar.getTime());

        datePic.setText(currentDateString);

        datePickerDialog.show();

    }

    private void init() {
        datePic = findViewById(R.id.dateTv);
        timePic = findViewById(R.id.timeTv);
    }



}

