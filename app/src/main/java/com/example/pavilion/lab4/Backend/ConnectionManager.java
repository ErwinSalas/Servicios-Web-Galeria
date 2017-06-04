package com.example.pavilion.lab4.Backend;

/**
 * Created by Pavilion on 2/6/2017.
 */
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectionManager {
    private String baseurl;
    private final Retrofit retrofit;
    private MainInterface mainInterface;


    public ConnectionManager() {
        this.baseurl = "http://services.groupkt.com";
        this.retrofit = new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build();
        this.mainInterface = retrofit.create(MainInterface.class);
    }

    public MainInterface getMainInterface() {
        return this.mainInterface;
    }
}
