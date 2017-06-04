package com.example.pavilion.lab4.Backend;

import java.util.ArrayList;

/**
 * Created by Pavilion on 3/6/2017.
 */
public class Galeries {
    public ArrayList<Galery> galeries;
    public static Galeries galeriesObject=null;

    public ArrayList<Galery> getGaleries() {
        return galeries;
    }

    public void setGaleries(ArrayList<Galery> galeries) {
        galeries = galeries;
    }

    private Galeries() {
        galeries=new ArrayList<>();
    }
    public static  Galeries getInstance(){
        if (galeriesObject==null){
            galeriesObject=new Galeries();
        }
        return galeriesObject;
    }
    public  Galery searchGalery(String name){
        for(Galery galery: galeries){
            if (galery.getCountryName().equals(name) ){
                return galery;
            }
        }
        return null;
    }
    public void addGalery(Galery photos){
        galeries.add(photos);

    }
    public void update(Galery newUpdate){
        for(Galery item:galeries){
            if (item.getCountryName().equals(newUpdate.getCountryName()) ){
                galeries.remove(item);
                galeries.add(newUpdate);
            }
        }

    }

}
