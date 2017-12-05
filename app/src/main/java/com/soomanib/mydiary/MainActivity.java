package com.soomanib.mydiary;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void todaysDiary(View view)
    {
        Intent intent = new Intent(this,DiaryActivity.class);
        startActivity(intent);
    }
    public void remindMeTomorrow(View view)
    {
        Intent intent = new Intent(this,RemindMeTomorrow.class);
        startActivity(intent);
    }
    public void oldMemories(View view)
    {
        Intent intent = new Intent(this, OldMemory.class);
        startActivity(intent);
    }
}
