package com.lurear.model;

/**
 * Created by security on 10/20/2017.
 */

public class LARCheckInOutModel {

    private String name;
    private String date;
    private String time;

    public LARCheckInOutModel(String name, String date, String time ) {
        this.name=name;
        this.date=date;
        this.time=time;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
