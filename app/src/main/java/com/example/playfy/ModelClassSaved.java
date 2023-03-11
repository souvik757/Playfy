package com.example.playfy;

import java.util.ArrayList;

public class ModelClassSaved {
    public static ArrayList<ModelClassSaved> _list  = new ArrayList<>();
        private int image ;
        private String text ;
        private String index ;

        public ModelClassSaved(int image, String text, String index) {
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
