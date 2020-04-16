package com.example.egyptcorona;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main4Activity extends AppCompatActivity {
    private TextView mtotalcase, mntotalcase,
            mdeath,mndeath,
            mrecovery,mactive,mdethpermillion,mcasespermillion;

    private DecimalFormat decimalFormat = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        connectionRetrofit();
    }

    public void connectionRetrofit(){
        mtotalcase = findViewById(R.id.mTotalCases);
        mntotalcase = findViewById(R.id.mToday_Cases);
        mdeath = findViewById(R.id.mTotalDeath);
        mndeath = findViewById(R.id.mToday_Death);
        mrecovery=findViewById(R.id.mTotal_recoverd);
        mactive=findViewById(R.id.mActrive_cases);
        mdethpermillion=findViewById(R.id.mDeathsPerOneMillion);
        mcasespermillion=findViewById(R.id.mCasesPerOneMillion);

        ProgressDialog progressDialog = new ProgressDialog(Main4Activity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Getting update..");
        progressDialog.show();


        //Egypt
        ApiServer.createService(ApiInterface.class).getapiEgypt().enqueue(new Callback<API>() {
            @Override
            public void onResponse(Call<API> call, Response<API> response) {
                progressDialog.dismiss();
                decimalFormat.setGroupingUsed(true);
                decimalFormat.setGroupingSize(3);

                mtotalcase.setText(decimalFormat.format(response.body().getCases()));
                mntotalcase.setText("+"+decimalFormat.format(response.body().getTodayCases()));
                mdeath.setText(decimalFormat.format(response.body().getDeaths()));
                mndeath.setText("+"+decimalFormat.format(response.body().getTodayDeaths()));
                mrecovery.setText(decimalFormat.format(response.body().getRecovered()));
                mactive.setText(decimalFormat.format(response.body().getActive()));
                mdethpermillion.setText(decimalFormat.format(response.body().getDeathsPerOneMillion()));
                mcasespermillion.setText(decimalFormat.format(response.body().getCasesPerOneMillion()));

            }

            @Override
            public void onFailure(Call<API> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(Main4Activity.this, "Check your Connection", Toast.LENGTH_SHORT).show();
                Log.v("haoooooooo",t.getMessage());
            }
        });

    }


    public void refresh(View view) {
        connectionRetrofit();
    }
}
