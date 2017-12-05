package com.soomanib.mydiary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USER on 12/5/2017.
 */

public abstract class Reminder extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Reminder_Database";
    private static final int DATABASE_VERSION = 1;

    public Reminder(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db)
    {
        //db.execSQL();
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //db.execSQL();
    }
}


