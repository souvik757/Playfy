package com.example.playfy;

public class ModelClass2nd {
    private int image ;
    private String text ;
    private String index ;

    public ModelClass2nd(int image, String text, String index) {
        this.image = image;
        this.text = text;
        this.index = index ;
    }

    public int getImage() {
        return image;
    }

    public String getText() {
        return text;
    }
    public String getIndex(){ return index; }

}
