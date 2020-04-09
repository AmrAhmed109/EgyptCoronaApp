package com.example.egyptcorona;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.NumberFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView  totalcase_num, totalcase_num_new,
                death_num,death_num_new,
                recovery_num;
        TextView  totalcase2_num, totalcase2_num_new,
                death2_num,death2_num_new,
                recovery2_num;

        totalcase_num = findViewById(R.id.TotalCases_num);
        totalcase_num_new = findViewById(R.id.TotalCases_newNum);
        death_num = findViewById(R.id.Deaths_num);
        death_num_new = findViewById(R.id.Deaths_new);
        recovery_num=findViewById(R.id.Recovered_num);

        totalcase2_num = findViewById(R.id.TotalCases_num2);
        totalcase2_num_new = findViewById(R.id.TotalCases_newNum2);
        death2_num = findViewById(R.id.Deaths_num2);
        death2_num_new = findViewById(R.id.Deaths_new2);
        recovery2_num=findViewById(R.id.Recovered_num2);



        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://corona.lmao.ninja/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ProgressDialog progressDialog = new ProgressDialog(Main2Activity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("wait..");
        progressDialog.show();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<API> apiCall = apiInterface.getapiEgypt();
        apiCall.enqueue(new Callback<API>() {
            @Override
            public void onResponse(Call<API> call, Response<API> response) {
                progressDialog.dismiss();

                String t1 = String.valueOf(response.body().getCases());
                String t2 = String.valueOf(response.body().getTodayCases());
                String d1 = String.valueOf(response.body().getDeaths());
                String d2 = String.valueOf(response.body().getTodayDeaths());
                String r1 = String.valueOf(response.body().getRecovered());
                totalcase2_num_new.setText("+"+t2);
                totalcase2_num.setText(t1);
                death2_num.setText(d1);
                death2_num_new.setText("+"+d2);
                recovery2_num.setText(r1);
            }

            @Override
            public void onFailure(Call<API> call, Throwable t) {
                progressDialog.dismiss();
                Log.v("haoooooooo",t.getMessage());
            }
        });

        Call<API> apiCall2 = apiInterface.getapiAll();
        apiCall2.enqueue(new Callback<API>() {
            @Override
            public void onResponse(Call<API> call, Response<API> response) {

            }

            @Override
            public void onFailure(Call<API> call, Throwable t) {

            }
        });

    }
}
