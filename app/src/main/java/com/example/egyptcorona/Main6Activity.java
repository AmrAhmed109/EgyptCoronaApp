package com.example.egyptcorona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if (getIntent().hasExtra("name")&
            getIntent().hasExtra("totalcase")&
            getIntent().hasExtra("totalcase_new")&
            getIntent().hasExtra("death")&
            getIntent().hasExtra("death_new")&
            getIntent().hasExtra("recovery")&
            getIntent().hasExtra("image")&
            getIntent().hasExtra("active")&
            getIntent().hasExtra("CasesPerOneMillion")&
            getIntent().hasExtra("DeathsPerOneMillion")){
    String name = getIntent().getStringExtra("name");
    String totalcase = getIntent().getStringExtra("totalcase");
    String totalcase_new = getIntent().getStringExtra("totalcase_new");
    String death = getIntent().getStringExtra("death");
    String death_new = getIntent().getStringExtra("death_new");
    String recovery = getIntent().getStringExtra("recovery");
    String image = getIntent().getStringExtra("image");
    String active = getIntent().getStringExtra("active");
    String CasesPerOneMillion = getIntent().getStringExtra("CasesPerOneMillion");
    String DeathsPerOneMillion = getIntent().getStringExtra("DeathsPerOneMillion");
    setName(name,totalcase,totalcase_new,death,death_new,recovery,image,active,CasesPerOneMillion,DeathsPerOneMillion);
        }
    }

    private void setName(String name, String cases , String tcases , String death , String tdeath , String recoverd , String imageurl , String active, String CasesPerOneMillion, String DeathsPerOneMillion ){
        TextView fCoronavirus_Global3 = findViewById(R.id.Coronavirus_Global3);
        TextView fTotalCases = findViewById(R.id.fTotalCases);
        TextView fToday_Cases = findViewById(R.id.fToday_Cases);
        TextView fTotalDeath = findViewById(R.id.fTotalDeath);
        TextView fToday_Death = findViewById(R.id.fToday_Death);
        TextView fTotal_recoverd = findViewById(R.id.fTotal_recoverd);
        TextView fActrive_cases = findViewById(R.id.fActrive_cases);
        TextView fCasesPerOneMillion = findViewById(R.id.fCasesPerOneMillion);
        TextView fDeathsPerOneMillion = findViewById(R.id.fDeathsPerOneMillion);
        CircleImageView circleImageView = findViewById(R.id.egyptflage109);
        fActrive_cases.setText(active);
        fCasesPerOneMillion.setText(CasesPerOneMillion);
        fDeathsPerOneMillion.setText(DeathsPerOneMillion);
        fCoronavirus_Global3.setText(name);
        fTotalCases.setText(cases);
        fToday_Cases.setText(tcases);
        fTotalDeath.setText(death);
        fToday_Death.setText(tdeath);
        fTotal_recoverd.setText(recoverd);
        Glide.with(this).load(imageurl).into(circleImageView);

    }
}
