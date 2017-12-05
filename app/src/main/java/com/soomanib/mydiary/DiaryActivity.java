package com.soomanib.mydiary;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.google.android.gms.internal.zzben.NULL;

public class DiaryActivity extends AppCompatActivity {
    Calendar calendar;
    SimpleDateFormat simpledateformat;
    String Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        Calendar c = Calendar.getInstance();
        int month=c.get(Calendar.MONTH)+1;
        String Month=NULL;
            if(month==1)
                Month="January";
            else if(month==2)
                Month="February";
            else if(month==3)
                Month="March";
            else if(month==4)
                Month="April";
            else if(month==5)
                Month="May";
            else if(month==6)
                Month="June";
            else if(month==7)
                Month="July";
            else if(month==8)
                Month="August";
            else if(month==9)
                Month="September";
            else if(month==10)
                Month="October";
            else if(month==11)
                Month="November";
            else if(month==12)
                Month="December";
        Date = c.get(Calendar.DAY_OF_MONTH) + " " + Month+ ", " + c.get(Calendar.YEAR);
        TextView textView = findViewById(R.id.textView2);
        textView.setText(Date);
    }
}
