package com.neko.passactivity;

public class Item {
    private String mName;
    private int mImage;
    private String mDetail;

    public Item(String mName, int mImage, String mDetail) {
        this.mName = mName;
        this.mImage = mImage;
        this.mDetail = mDetail;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public void setmDetail(String mDetail) {
        this.mDetail = mDetail;
    }

    public String getmDetail() {
        return mDetail;
    }
}