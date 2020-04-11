package com.example.egyptcorona;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
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

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
       /* TextView mtotalcase, mntotalcase,
                mdeath,mndeath,
                mrecovery,mactive;
        TextView  totalcase2_num, totalcase2_num_new,
                death2_num,death2_num_new,
                recovery2_num,updateEgypt;

        mtotalcase = findViewById(R.id.mTotalCases);
        mntotalcase = findViewById(R.id.mToday_Cases);
        mdeath = findViewById(R.id.mTotalDeath);
        mndeath = findViewById(R.id.mToday_Death);
        mrecovery=findViewById(R.id.mTotal_recoverd);
        mactive=findViewById(R.id.mActrive_cases);

        ProgressDialog progressDialog = new ProgressDialog(Main4Activity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Getting update..");
        progressDialog.show();


        //Egypt
        ApiServer.createService(ApiInterface.class).getapiEgypt().enqueue(new Callback<API>() {
            @Override
            public void onResponse(Call<API> call, Response<API> response) {
                progressDialog.dismiss();
                String t1 = String.valueOf(response.body().getCases());
                String t2 = String.valueOf(response.body().getTodayCases());
                String d1 = String.valueOf(response.body().getDeaths());
                String d2 = String.valueOf(response.body().getTodayDeaths());
                String r1 = String.valueOf(response.body().getRecovered());
                String a1 = String.valueOf(response.body().getActive());
                mtotalcase.setText(t1);
                mntotalcase.setText("+"+t2);
                mdeath.setText(d1);
                mndeath.setText("+"+d2);
                mrecovery.setText(r1);
                mactive.setText(a1);

            }

            @Override
            public void onFailure(Call<API> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(Main4Activity.this, "Check your Connection", Toast.LENGTH_SHORT).show();
                Log.v("haoooooooo",t.getMessage());
            }
        });*/
    }
}
