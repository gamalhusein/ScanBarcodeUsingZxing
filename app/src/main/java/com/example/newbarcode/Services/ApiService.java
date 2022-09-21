package com.example.newbarcode.Services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static  final String BASE_URL = "http://portal.scu.co.id:1881/all-demo/";
    private static Retrofit retrofit;

    public static Retrofit getBarcode(){
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
