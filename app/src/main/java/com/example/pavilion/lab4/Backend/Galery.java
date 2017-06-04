package com.example.pavilion.lab4.Backend;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by Pavilion on 3/6/2017.
 */
public class Galery {
    private String countryName;
    private ArrayList<Bitmap> images;

    public Galery(String countryName, ArrayList<Bitmap> images) {
        this.countryName = countryName;
        this.images = images;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public ArrayList<Bitmap> getImages() {
        return images;
    }

    public void setImages(ArrayList<Bitmap> images) {
        this.images = images;
    }

    public void addPhoto(Bitmap img){
        if (this.images==null){
            this.images=new ArrayList<Bitmap>();
            this.images.add(img);
        }
        else {
            this.images.add(img);
        }

    }
}
