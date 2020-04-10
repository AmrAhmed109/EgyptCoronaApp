package com.example.egyptcorona;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServer {
    private static String url = "https://corona.lmao.ninja/";
    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static ApiInterface apiInterface;

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(url).addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass){
        Retrofit retrofit = builder.client(okHttpClient).build();
        return retrofit.create(serviceClass);
    }

    public static Retrofit getRetrofitClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface = retrofit.create(ApiInterface.class);
        }
        return retrofit;
    }

}

