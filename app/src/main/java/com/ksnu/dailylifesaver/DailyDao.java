package com.ksnu.dailylifesaver;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DailyDao {
    @Query("SELECT * FROM DailyData")
    List<DailyData> getAll();

    @Insert
    void insert(DailyData dailyData);

    @Update
    void update(DailyData dailyData);

    @Delete
    void delete(DailyData dailyData);


}
