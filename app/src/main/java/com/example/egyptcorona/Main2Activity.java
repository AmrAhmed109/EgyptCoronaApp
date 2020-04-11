package com.example.egyptcorona;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView  totalcase_num, totalcase_num_new,
                death_num,death_num_new,
                recovery_num,updateGlobal;
        TextView  totalcase2_num, totalcase2_num_new,
                death2_num,death2_num_new,
                recovery2_num,updateEgypt;

        totalcase_num = findViewById(R.id.TotalCases_num);
        totalcase_num_new = findViewById(R.id.TotalCases_newNum);
        death_num = findViewById(R.id.Deaths_num);
        death_num_new = findViewById(R.id.Deaths_new);
        recovery_num=findViewById(R.id.Recovered_num);
        updateGlobal=findViewById(R.id.global_update);

        totalcase2_num = findViewById(R.id.TotalCases_num2);
        totalcase2_num_new = findViewById(R.id.TotalCases_newNum2);
        death2_num = findViewById(R.id.Deaths_num2);
        death2_num_new = findViewById(R.id.Deaths_new2);
        recovery2_num=findViewById(R.id.Recovered_num2);
        updateEgypt=findViewById(R.id.egypt_update);




        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();


        ProgressDialog progressDialog = new ProgressDialog(Main2Activity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Getting update..");
        progressDialog.show();


        //Egypt
        ApiServer.createService(ApiInterface.class).getapiEgypt().enqueue(new Callback<API>() {
            @Override
            public void onResponse(Call<API> call, Response<API> response) {
                String t1 = String.valueOf(response.body().getCases());
                String t2 = String.valueOf(response.body().getTodayCases());
                String d1 = String.valueOf(response.body().getDeaths());
                String d2 = String.valueOf(response.body().getTodayDeaths());
                String r1 = String.valueOf(response.body().getRecovered());
                totalcase2_num.setText(t1);
                totalcase2_num_new.setText("+"+t2);
                death2_num.setText(d1);
                death2_num_new.setText("+"+d2);
                recovery2_num.setText(r1);

                Date date2 = new Date(response.body().getUpdated());
                DateFormat formatter2 = new SimpleDateFormat("dd MMMM hh:mm aa");
                formatter2.setTimeZone(TimeZone.getTimeZone("UTC"));
                String dateFormatted2 = formatter2.format(date2);
                updateEgypt.setText(dateFormatted2);
            }

            @Override
            public void onFailure(Call<API> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(Main2Activity.this, "Check your Connection", Toast.LENGTH_SHORT).show();
                Log.v("haoooooooo",t.getMessage());
            }
        });



        ApiServer.createService(ApiInterface.class).getapiAllGlobal().enqueue(new Callback<Api3>() {
            @Override
            public void onResponse(Call<Api3> call, Response<Api3> response) {
                progressDialog.dismiss();
                String t11 = String.valueOf(response.body().getCases());
                String t12 = String.valueOf(response.body().getTodayCases());
                String d11 = String.valueOf(response.body().getDeaths());
                String d12 = String.valueOf(response.body().getTodayDeaths());
                String r11 = String.valueOf(response.body().getRecovered());
                totalcase_num.setText(t11);
                totalcase_num_new.setText("+"+t12);
                death_num.setText(d11);
                death_num_new.setText("+"+d12);
                recovery_num.setText(r11);


                Date date = new Date(response.body().getUpdated());
                DateFormat formatter = new SimpleDateFormat("dd MMMM hh:mm aa");
                formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
                String dateFormatted = formatter.format(date);
                updateGlobal.setText(dateFormatted);

            }

            @Override
            public void onFailure(Call<Api3> call, Throwable t) {
                Toast.makeText(Main2Activity.this, "Check your Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void seeCounry(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    public void test(View view) {
        Intent intent =new Intent(this,Main3Activity.class);
        startActivity(intent);
    }

    public void refresh(View view) {
        TextView  totalcase_num, totalcase_num_new,
                death_num,death_num_new,
                recovery_num,updateGlobal;
        TextView  totalcase2_num, totalcase2_num_new,
                death2_num,death2_num_new,
                recovery2_num,updateEgypt;

        totalcase_num = findViewById(R.id.TotalCases_num);
        totalcase_num_new = findViewById(R.id.TotalCases_newNum);
        death_num = findViewById(R.id.Deaths_num);
        death_num_new = findViewById(R.id.Deaths_new);
        recovery_num=findViewById(R.id.Recovered_num);
        updateGlobal=findViewById(R.id.global_update);

        totalcase2_num = findViewById(R.id.TotalCases_num2);
        totalcase2_num_new = findViewById(R.id.TotalCases_newNum2);
        death2_num = findViewById(R.id.Deaths_num2);
        death2_num_new = findViewById(R.id.Deaths_new2);
        recovery2_num=findViewById(R.id.Recovered_num2);
        updateEgypt=findViewById(R.id.egypt_update);




        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();


        ProgressDialog progressDialog = new ProgressDialog(Main2Activity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Getting update..");
        progressDialog.show();


        //Egypt
        ApiServer.createService(ApiInterface.class).getapiEgypt().enqueue(new Callback<API>() {
            @Override
            public void onResponse(Call<API> call, Response<API> response) {
                String t1 = String.valueOf(response.body().getCases());
                String t2 = String.valueOf(response.body().getTodayCases());
                String d1 = String.valueOf(response.body().getDeaths());
                String d2 = String.valueOf(response.body().getTodayDeaths());
                String r1 = String.valueOf(response.body().getRecovered());
                totalcase2_num.setText(t1);
                totalcase2_num_new.setText("+"+t2);
                death2_num.setText(d1);
                death2_num_new.setText("+"+d2);
                recovery2_num.setText(r1);

                Date date2 = new Date(response.body().getUpdated());
                DateFormat formatter2 = new SimpleDateFormat("dd MMMM hh:mm aa");
                formatter2.setTimeZone(TimeZone.getTimeZone("UTC"));
                String dateFormatted2 = formatter2.format(date2);
                updateEgypt.setText(dateFormatted2);
            }

            @Override
            public void onFailure(Call<API> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(Main2Activity.this, "Check your Connection", Toast.LENGTH_SHORT).show();
                Log.v("haoooooooo",t.getMessage());
            }
        });



        ApiServer.createService(ApiInterface.class).getapiAllGlobal().enqueue(new Callback<Api3>() {
            @Override
            public void onResponse(Call<Api3> call, Response<Api3> response) {
                progressDialog.dismiss();
                String t11 = String.valueOf(response.body().getCases());
                String t12 = String.valueOf(response.body().getTodayCases());
                String d11 = String.valueOf(response.body().getDeaths());
                String d12 = String.valueOf(response.body().getTodayDeaths());
                String r11 = String.valueOf(response.body().getRecovered());
                totalcase_num.setText(t11);
                totalcase_num_new.setText("+"+t12);
                death_num.setText(d11);
                death_num_new.setText("+"+d12);
                recovery_num.setText(r11);


                Date date = new Date(response.body().getUpdated());
                DateFormat formatter = new SimpleDateFormat("dd MMMM hh:mm aa");
                formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
                String dateFormatted = formatter.format(date);
                updateGlobal.setText(dateFormatted);

            }

            @Override
            public void onFailure(Call<Api3> call, Throwable t) {
                Toast.makeText(Main2Activity.this, "Check your Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
