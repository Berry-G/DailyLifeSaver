package com.ksnu.dailylifesaver;

import android.database.sqlite.SQLiteDatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {DailyData.class}, version = 1)
public abstract class DailyDatabase extends RoomDatabase {
    public abstract DailyDao dailyDao();
}
