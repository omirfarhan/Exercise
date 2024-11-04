package com.example.exercise;

import android.net.Uri;

public class LoadData {

    Uri imageview;
    String textview;

    public LoadData(Uri imageview, String textview) {
        this.imageview = imageview;
        this.textview = textview;
    }

    public Uri getImageview() {
        return imageview;
    }

    public void setImageview(Uri imageview) {
        this.imageview = imageview;
    }

    public String getTextview() {
        return textview;
    }

    public void setTextview(String textview) {
        this.textview = textview;
    }
}
