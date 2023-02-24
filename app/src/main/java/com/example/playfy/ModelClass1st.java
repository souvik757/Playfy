package com.example.playfy ;

import android.graphics.drawable.Drawable;
import android.view.View;

public class ModelClass1st {
    private int image ;
    private String text ;

    Class name ;

    Drawable drawable1 , drawable2 ;
    View view1 , view2;
    public ModelClass1st(int image, String text , Class name ,
                         Drawable drawable1 , Drawable drawable2) {
        this.image = image;
        this.text = text;
        this.name = name ;
        this.drawable1 = drawable1 ;
        this.drawable2 = drawable2 ;
    }

    public Class getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getText() {
        return text;
    }

    public Drawable getDrawable1() {
        return drawable1;
    }

    public Drawable getDrawable2() {
        return drawable2;
    }
}
