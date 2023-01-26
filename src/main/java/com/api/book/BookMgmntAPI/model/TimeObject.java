package com.api.book.BookMgmntAPI.model;

public class TimeObject {
    private String time;
    private long unixtime;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(Long unixtime) {
        this.unixtime = unixtime;
    }
}
