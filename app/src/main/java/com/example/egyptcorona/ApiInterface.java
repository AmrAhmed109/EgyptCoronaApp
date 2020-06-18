package com.example.egyptcorona;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("v2/countries/egypt")
    public Call<API> getapiEgypt();

    @GET("v2/countries")
    public Call<List<Api2>> getapiAll();

    @GET("v2/all")
    public Call<Api3> getapiAllGlobal();

    @GET("all")
    public Call<Api3> getapiAllGlobal2();

    @GET("v2/countries/")
    public Call<List<API>> getapiall2();

    // + country name from the intent
    // url + country name


}

