package com.ksnu.dailylifesaver;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DailyData {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String time_start;
    private String time_end;
    private int isMon;
    private int isTue;
    private int isWed;
    private int isThu;
    private int isFri;
    private int isSat;
    private int isSun;
    private int onOff;

    public DailyData(String title, String time_start, String time_end, int isMon, int isTue, int isWed, int isThu, int isFri, int isSat, int isSun, int onOff) {
        this.title = title;
        this.time_start = time_start;
        this.time_end = time_end;
        this.isMon = isMon;
        this.isTue = isTue;
        this.isWed = isWed;
        this.isThu = isThu;
        this.isFri = isFri;
        this.isSat = isSat;
        this.isSun = isSun;
        this.onOff = onOff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public int getIsMon() {
        return isMon;
    }

    public void setIsMon(int isMon) {
        this.isMon = isMon;
    }

    public int getIsTue() {
        return isTue;
    }

    public void setIsTue(int isTue) {
        this.isTue = isTue;
    }

    public int getIsWed() {
        return isWed;
    }

    public void setIsWed(int isWed) {
        this.isWed = isWed;
    }

    public int getIsThu() {
        return isThu;
    }

    public void setIsThu(int isThu) {
        this.isThu = isThu;
    }

    public int getIsFri() {
        return isFri;
    }

    public void setIsFri(int isFri) {
        this.isFri = isFri;
    }

    public int getIsSat() {
        return isSat;
    }

    public void setIsSat(int isSat) {
        this.isSat = isSat;
    }

    public int getIsSun() {
        return isSun;
    }

    public void setIsSun(int isSun) {
        this.isSun = isSun;
    }

    public int getOnOff() {
        return onOff;
    }

    public void setOnOff(int onOff) {
        this.onOff = onOff;
    }


    @Override
    public String toString() {
        return "DailyData{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", time_start='" + time_start + '\'' +
                ", time_end='" + time_end + '\'' +
                ", isMon=" + isMon +
                ", isTue=" + isTue +
                ", isWed=" + isWed +
                ", isThu=" + isThu +
                ", isFri=" + isFri +
                ", isSat=" + isSat +
                ", isSun=" + isSun +
                ", onOff=" + onOff +
                '}';
    }
}