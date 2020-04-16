package com.example.egyptcorona;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main5Activity extends AppCompatActivity {
    private TextView etotalcase, entotalcase,
            edeath, endeath,
            erecovery, eactive,edethpermillion,ecasespermillion;

    private DecimalFormat decimalFormat = new DecimalFormat("#.##");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        connectionRetrofit2();
    }

    public void connectionRetrofit2() {
        etotalcase = findViewById(R.id.eTotalCases);
        entotalcase = findViewById(R.id.eToday_Cases);
        edeath = findViewById(R.id.eTotalDeath);
        endeath = findViewById(R.id.eToday_Death);
        erecovery = findViewById(R.id.eTotal_recoverd);
        eactive = findViewById(R.id.eActrive_cases);
        edethpermillion=findViewById(R.id.eDeathsPerOneMillion);
        ecasespermillion=findViewById(R.id.eCasesPerOneMillion);

        ProgressDialog progressDialog = new ProgressDialog(Main5Activity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Getting update..");
        progressDialog.show();


        //Egypt
        ApiServer.createService(ApiInterface.class).getapiAllGlobal().enqueue(new Callback<Api3>() {
            @Override
            public void onResponse(Call<Api3> call, Response<Api3> response) {
                progressDialog.dismiss();

                decimalFormat.setGroupingUsed(true);
                decimalFormat.setGroupingSize(3);

                etotalcase.setText(decimalFormat.format(response.body().getCases()));
                entotalcase.setText("+" + decimalFormat.format(response.body().getTodayCases()));
                edeath.setText(decimalFormat.format(response.body().getDeaths()));
                endeath.setText("+" + decimalFormat.format(response.body().getTodayDeaths()));
                erecovery.setText(decimalFormat.format(response.body().getRecovered()));
                eactive.setText(decimalFormat.format(response.body().getActive()));
                edethpermillion.setText(decimalFormat.format(response.body().getDeathsPerOneMillion()));
                ecasespermillion.setText(decimalFormat.format(response.body().getCasesPerOneMillion()));

            }

            @Override
            public void onFailure(Call<Api3> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(Main5Activity.this, "Check your Connection", Toast.LENGTH_SHORT).show();
                Log.v("haoooooooo", t.getMessage());
            }
        });
    }



    public void ew(View view) {
        connectionRetrofit2();
    }
}