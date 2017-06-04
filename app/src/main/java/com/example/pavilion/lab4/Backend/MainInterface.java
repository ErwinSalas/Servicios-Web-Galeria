package com.example.pavilion.lab4.Backend;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Pavilion on 2/6/2017.
 */
public interface MainInterface {
    @GET("/country/get/all")
    Call<Data> getCountries();
}
