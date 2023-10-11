package buinz.caka.gamexephinh.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import buinz.caka.gamexephinh.model.HistoryModel;


public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "GameData.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "games";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_TIME = "time";
    public static final String COLUMN_MOVES = "moves";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TYPE + " TEXT,"
                + COLUMN_TIME + " TEXT,"
                + COLUMN_MOVES + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void addGame(String type, String time, String moves) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TYPE, type);
        values.put(COLUMN_TIME, time);
        values.put(COLUMN_MOVES, moves);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public ArrayList<HistoryModel> getLastTenRecordsByType(String typeValue) {
        ArrayList<HistoryModel> historyList = new ArrayList<>();

        // Sắp xếp theo ID giảm dần để lấy 10 bản ghi mới nhất
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_TYPE + " = ? ORDER BY " + COLUMN_ID + " DESC LIMIT 10";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, new String[]{typeValue});

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
                String type = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TYPE));
                String time = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TIME));
                String moves = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MOVES));
                HistoryModel historyModel = new HistoryModel(id, type, time, moves);
                historyList.add(historyModel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return historyList;
    }


}
