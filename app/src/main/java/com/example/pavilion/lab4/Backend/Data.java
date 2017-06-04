package com.example.pavilion.lab4.Backend;

/**
 * Created by Pavilion on 2/6/2017.
 */
public class Data {
    RestResponse RestResponse;

    public RestResponse getRestResponse() {
        return RestResponse;
    }

    public void setRestResponse(RestResponse info) {
        this.RestResponse = info;
    }

    public Data(RestResponse info) {
        this.RestResponse = info;
    }
}
