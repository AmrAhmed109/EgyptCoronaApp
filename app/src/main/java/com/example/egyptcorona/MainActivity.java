package com.example.egyptcorona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<API> userListResponses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle_view);
        getUserListData();
    }
    private void getUserListData(){
        final ProgressDialog progressDialog =new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please Wait");
        progressDialog.show();
        ApiServer.createService(ApiInterface.class).getapiAll().enqueue(new Callback<List<API>>() {
        @Override
        public void onResponse(Call<List<API>> call, Response<List<API>> response) {
            Log.d("responsGET",response.body().get(0).getCountry());
            progressDialog.dismiss();
            userListResponses = response.body();
            setDataInRecyclerView();
        }

        @Override
        public void onFailure(Call<List<API>> call, Throwable t) {
            Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            Log.v("oooooooooooo",t.getMessage());
            progressDialog.dismiss();
        }
    });

    }

    public void setDataInRecyclerView(){
        //LinearLayoutManager linearLayoutManager =new LinearLayoutManager(MainActivity.this);
        //recyclerView.setLayoutManager(linearLayoutManager);
       // UsersAdapter usersAdapter = new UsersAdapter(MainActivity.this,userListResponses);
        //recyclerView.setAdapter(usersAdapter);


        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        UsersAdapter usersAdapter = new UsersAdapter(MainActivity.this,userListResponses);
        recyclerView.setAdapter(usersAdapter);

    }
}
