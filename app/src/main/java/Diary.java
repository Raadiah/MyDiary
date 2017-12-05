import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by USER on 12/5/2017.
 */

public class Diary extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "Diary_Database";
    private static final int DATABASE_VERSION = 1;

    public static final String DB_TABLE = "Task";
    public static final String DB_COLUMN = "Task_Column";

    public Diary(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db)
    {
        String query = String.format("CREATE TABLE %s (ID INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL)",DB_TABLE, DB_COLUMN);
        db.execSQL(query);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String query = String.format("DELETE TABLE IF EXISTS %s",DB_TABLE);
        db.execSQL(query);
        onCreate(db);
    }

    public void insertNewTask (String Task)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DB_COLUMN,Task);
        db.insertWithOnConflict(DB_TABLE,0,values,SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }

    public void deleteTask (String Task)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_TABLE," - ?", new String[]{Task});
        db.close();
    }

    public ArrayList<String> getTaskList ()
    {
        ArrayList<String> TaskList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(DB_TABLE, new String[]{DB_COLUMN},null,null,null,null,null );
        while (cursor.moveToNext())
        {
            int index = cursor.getColumnIndex(DB_COLUMN);
            TaskList.add(cursor.getString(index));
        }
        cursor.close();
        db.close();
        return TaskList;
    }
}
