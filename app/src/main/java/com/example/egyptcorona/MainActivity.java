package com.example.egyptcorona;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://corona.lmao.ninja/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("wait..");
        progressDialog.show();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<Api3> apiCall = apiInterface.getapiAllGlobal();
        apiCall.enqueue(new Callback<Api3>() {
            @Override
            public void onResponse(Call<Api3> call, Response<Api3> response) {
                progressDialog.dismiss();
                String s = String.valueOf(response.body().getActive());


            }

            @Override
            public void onFailure(Call<Api3> call, Throwable t) {
                progressDialog.dismiss();

                Log.v("haoooooooo",t.getMessage());
            }
        });

    }
}
