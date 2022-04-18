package com.example.myapplication;

public class dataclass {

    private int imageview1;
    private String textview;
    private String textview2;
    private String textview3;
    private String textview4;

    public dataclass(){}
    public dataclass(int imageview1,String textview,String textview2 , String textview3, String textview4) {
        this.imageview1 = imageview1;
        this.textview = textview;
        this.textview2 = textview2;
        this.textview3 = textview3;
        this.textview4 = textview4;
    }

    public int getImageview1() {
        return imageview1;
    }

    public void setImageview1(int imageview1) {
        this.imageview1 = imageview1;
    }

    public String getTextview() {
        return textview;
    }

    public void setTextview(String textview) {
        this.textview = textview;
    }

    public String getTextview2() {
        return textview2;
    }

    public void setTextview2(String textview2) {
        this.textview2 = textview2;
    }

    public String getTextview3() {
        return textview3;
    }

    public void setTextview3(String textview3) {
        this.textview3 = textview3;
    }

    public String getTextview4() {
        return textview4;
    }

    public void setTextview4(String textview4) {
        this.textview4 = textview4;
    }
}
