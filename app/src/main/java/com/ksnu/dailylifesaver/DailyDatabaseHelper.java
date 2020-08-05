package com.ksnu.dailylifesaver;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DailyDatabaseHelper extends SQLiteOpenHelper {
    public static String NAME = "dailysaver.db";
    public static int VERSION = 1;

    public DailyDatabaseHelper(Context context)
    {
        super(context, NAME, null, VERSION);
    }

    public void onCreate(SQLiteDatabase db)
    {
        //onCreate 호출

        String sql = "create table if not exists daily("
                + "_id integer PRIMARY KEY autoincrement,"
                + "title text,"
                + "time_start text,"
                + "time_end text,"
                + "ismon integer,"
                + "istue integer,"
                + "iswed integer,"
                + "isthu integer,"
                + "isfri integer,"
                + "issat integer,"
                + "issun integer,"
                + "onoff integer)";

        db.execSQL(sql);
    }

    public void onOpen(SQLiteDatabase db)
    {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if(newVersion > 1)
        {
            db.execSQL("DROP TABLE IF EXISTS daily");
        }
    }

    public void addDaily(DailyData daily)
    {
        SQLiteDatabase db=getWritableDatabase();

        StringBuffer sb=new StringBuffer();
        sb.append(" INSERT INTO daily ( ");
        sb.append(" title, time_start, time_end, ismon, istue, iswed, isthu, isfri, issat, issun, onoff )");
        sb.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        db.execSQL(sb.toString(),
                new Object[]{
                        daily.getTitle(),
                        daily.getTime_start(),
                        daily.getTime_end(),
                        daily.getIsMon(),
                        daily.getIsTue(),
                        daily.getIsWed(),
                        daily.getIsThu(),
                        daily.getIsFri(),
                        daily.getIsSat(),
                        daily.getIsSun(),
                        daily.getOnOff(),
                });
    }

    public void updateDaily(DailyData daily)
    {
        SQLiteDatabase db=getWritableDatabase();

        StringBuffer sb = new StringBuffer();
        sb.append(" UPDATE daily SET ( ");
        sb.append(" title = ?, time_start = ?, time_end = ?, ismon = ?, istue = ?, iswed = ?, isthu = ?, isfri = ?, issat = ?, issun = ?, onoff = ? )");
        sb.append(" WHERE _id = ?");

        db.execSQL(sb.toString(),
                new Object[]{
                        daily.getTitle(),
                        daily.getTime_start(),
                        daily.getTime_end(),
                        daily.getIsMon(),
                        daily.getIsTue(),
                        daily.getIsWed(),
                        daily.getIsThu(),
                        daily.getIsFri(),
                        daily.getIsSat(),
                        daily.getIsSun(),
                        daily.getOnOff(),
                });
    }

    public void deleteDaily(DailyData daily)
    {
        SQLiteDatabase db=getWritableDatabase();

        StringBuffer sb = new StringBuffer();
        sb.append(" DELETE FROM daily WHERE _id = ?");

        db.execSQL(sb.toString(),
                new Object[]{
                        daily.getId()
                });
    }
}
