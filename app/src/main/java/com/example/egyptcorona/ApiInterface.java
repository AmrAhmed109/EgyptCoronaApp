package com.example.egyptcorona;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("countries/Egypt")
    public Call<API> getapiEgypt();

    @GET("countries")
    public Call<List<API>> getapiAll();

    @GET("all")
    public Call<Api3> getapiAllGlobal();

}

