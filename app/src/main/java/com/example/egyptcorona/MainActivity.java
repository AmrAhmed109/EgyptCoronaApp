package com.example.egyptcorona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Api2> userListResponses;
    UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle_view);
        getUserListData();
        setupdate();
        EditText editText = findViewById(R.id.textedit);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });




    }

    private void filter (String text){
        ArrayList<Api2> filteredlist = new ArrayList<>();
        for (Api2 api2 : userListResponses){
            if (api2.getCountry().toLowerCase().contains(text.toLowerCase().trim())){
                filteredlist.add(api2);
            }
        }


        usersAdapter.fiterlist(filteredlist);

    }

    private void getUserListData(){
        final ProgressDialog progressDialog =new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Getting update..");
        progressDialog.show();

        //Retrofit retrofit = ApiServer.getRetrofitClient();
        // ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        // Call<List<Api2>> listCall = apiInterface.getapiAll();
        ApiServer.createService(ApiInterface.class).getapiAll().enqueue(new Callback<List<Api2>>() {
            @Override
            public void onResponse(Call<List<Api2>> call, Response<List<Api2>> response) {
                progressDialog.dismiss();
                userListResponses=response.body();
                setDataInRecyclerView();
            }

            @Override
            public void onFailure(Call<List<Api2>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void setDataInRecyclerView(){
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        usersAdapter = new UsersAdapter(MainActivity.this,userListResponses);
        recyclerView.setAdapter(usersAdapter);

        // LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false);
        // recyclerView.setLayoutManager(manager);
        // recyclerView.setHasFixedSize(true);
        // UsersAdapter usersAdapter = new UsersAdapter(MainActivity.this,userListResponses);
        // recyclerView.setAdapter(usersAdapter);

    }

    public void setupdate(){
        TextView textView = findViewById(R.id.updatedanother);
        ApiServer.createService(ApiInterface.class).getapiAllGlobal().enqueue(new Callback<Api3>() {
            @Override
            public void onResponse(Call<Api3> call, Response<Api3> response) {


                Date date = new Date(response.body().getUpdated());
                DateFormat formatter = new SimpleDateFormat("dd MMMM hh:mm aa");
                formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
                String dateFormatted = formatter.format(date);
                textView.setText(dateFormatted);

            }

            @Override
            public void onFailure(Call<Api3> call, Throwable t) {

            }
        });
    }

    public void refresh(View view) {
        getUserListData();
        setupdate();
    }

}