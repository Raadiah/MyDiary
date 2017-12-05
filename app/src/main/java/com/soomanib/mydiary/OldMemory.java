package com.soomanib.mydiary;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static com.google.android.gms.internal.zzben.NULL;

public class OldMemory extends AppCompatActivity {

    private static final String TAG = "OldMemoryActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    String Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_memory);
        mDisplayDate = (TextView) findViewById(R.id.textSelectDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                java.util.Calendar cal = java.util.Calendar.getInstance();
                int year = cal.get(java.util.Calendar.YEAR);
                int month = cal.get(java.util.Calendar.MONTH);
                int day = cal.get(java.util.Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(OldMemory.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                cal.set(2015,0,1);
                dialog.getDatePicker().setMinDate(cal.getTimeInMillis());
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override

            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String Month=NULL;
                Log.d(TAG, "onDateSet: dd/mm/yyyy: "+dayOfMonth+" " +month+", "+year);
                if(month==0)
                    Month="January";
                else if(month==1)
                    Month="February";
                else if(month==2)
                    Month="March";
                else if(month==3)
                    Month="April";
                else if(month==4)
                    Month="May";
                else if(month==5)
                    Month="June";
                else if(month==6)
                    Month="July";
                else if(month==7)
                    Month="August";
                else if(month==8)
                    Month="September";
                else if(month==9)
                    Month="October";
                else if(month==10)
                    Month="November";
                else if(month==11)
                    Month="December";
                Date = dayOfMonth+" " +Month+", "+year;
                mDisplayDate.setText(Date);
            }
        };
    }

    public void goToDate(View view)
    {
        Intent intent = new Intent(OldMemory.this,ShowMemory.class);
        startActivity(intent);
    }

    public void openMemoryMap(View view)
    {
        Intent intent = new Intent(OldMemory.this,MemoryMap.class);
        startActivity(intent);
    }


}
