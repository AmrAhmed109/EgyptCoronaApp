package com.example.egyptcorona;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("countries/Egypt")
    public Call<API> getapiEgypt();

    @GET("api/v1/data/world")
    public Call<List<Api2>> getapiAll();

    @GET("all")
    public Call<Api3> getapiAllGlobal();

    @GET("all")
    public Call<Api3> getapiAllGlobal2();

    @GET("all")
    public Call<List<API>> getapionce();

}

