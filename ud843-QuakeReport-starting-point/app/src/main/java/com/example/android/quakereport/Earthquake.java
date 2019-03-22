package com.example.android.quakereport;

public class Earthquake {

    private double mMagnitude;
    private String mPlace;
    private long mDate;

    public Earthquake(double Magnitude, String Place, long Date) {
        mMagnitude = Magnitude;
        mPlace = Place;
        mDate = Date;
    }

    public double getmMagnitude() {
        return mMagnitude;
    }

    public String getmPlace() {
        return mPlace;
    }

    public long getmDate() {
        return mDate;
    }


}
