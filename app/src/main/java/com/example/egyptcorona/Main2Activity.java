package com.example.egyptcorona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;
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



public class Main2Activity extends AppCompatActivity {
    private TextView  totalcase_num, totalcase_num_new,
            death_num,death_num_new,
            recovery_num,updateGlobal;
    private TextView  totalcase2_num, totalcase2_num_new,
            death2_num,death2_num_new,
            recovery2_num,updateEgypt;
    private int myPREFERENCES = 0 ;
    SharedPreferences sharedpreferences;
    int count = 0;



    @Override
    protected void onPause() {
        super.onPause();
      //  Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        Thread thread = new Thread(){
            @Override
            public void run(){
                while (!isInterrupted()){

                    try {
                        Thread.sleep(600000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count++;
                          //   Toast.makeText(Main2Activity.this, String.valueOf(count), Toast.LENGTH_SHORT).show();
                                connection();
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }

        };
        thread.start();

        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        if (todaycase > 0){

            sendNotification("Last update about Egypt Cases for now","Today Cases in Egypt is "+String.valueOf(decimalFormat.format(sharedpreferences.getInt("data",0)))+" cases");

        }
    }

    private int todaycase;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        if (todaycase > 0){

            sendNotification("Last update about Egypt Cases for now","Today Cases in Egypt is "+String.valueOf(decimalFormat.format(sharedpreferences.getInt("data",0)))+" cases");

        }
        Thread thread = new Thread(){
            @Override
            public void run(){
                while (!isInterrupted()){

                    try {
                        Thread.sleep(600000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count++;
                             //   Toast.makeText(Main2Activity.this, String.valueOf(count), Toast.LENGTH_SHORT).show();
                                connection();
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }

        };
        thread.start();


    }

    private DecimalFormat decimalFormat = new DecimalFormat("#.##");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
       connection();
       connection2();
        ImageView button = findViewById(R.id.image223);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification("Last update about Egypt Cases for now","Today Cases in Egypt is "+String.valueOf(myPREFERENCES)+" cases");

            }
        });
     /*  if (todaycase >= 0){

                sendNotification("Last update about Egypt Cases for now","Today Cases in Egypt is "+String.valueOf(sharedpreferences.getInt("data",0))+" cases");
        }*/
       // getprefrence();

       /* SharedPreferences.Editor myedit = sharedpreferences.edit();
        myedit.putInt("data",myPREFERENCES);
        myedit.commit();*/

        sharedpreferences.getInt("data",0);


       /* if (sharedpreferences.getInt("data",0) < myPREFERENCES){
            sendNotification("title",String.valueOf(myPREFERENCES));
            myedit.putInt("data",myPREFERENCES);
            myedit.commit();
        }*/


      Thread thread = new Thread(){
          @Override
          public void run(){
              while (!isInterrupted()){

                  try {
                      Thread.sleep(600000);
                      runOnUiThread(new Runnable() {
                          @Override
                          public void run() {
                              count++;
                            // Toast.makeText(Main2Activity.this, String.valueOf(count), Toast.LENGTH_SHORT).show();
                              connection();
                          }
                      });
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }


              }
          }

      };
thread.start();


    }



    public void connection(){
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


        //Egypt
        ApiServer.createService(ApiInterface.class).getapiEgypt().enqueue(new Callback<API>() {
            @Override
            public void onResponse(Call<API> call, Response<API> response) {
                Toast.makeText(Main2Activity.this, "refreshed", Toast.LENGTH_SHORT).show();
                decimalFormat.setGroupingUsed(true);
                decimalFormat.setGroupingSize(3);
                totalcase2_num.setText(decimalFormat.format(response.body().getCases()));
                totalcase2_num_new.setText("+"+ decimalFormat.format(response.body().getTodayCases()));
                death2_num.setText( decimalFormat.format(response.body().getDeaths()));
                death2_num_new.setText("+"+decimalFormat.format(response.body().getTodayDeaths()));
                recovery2_num.setText( decimalFormat.format(response.body().getRecovered()));
                todaycase = response.body().getTodayCases();

                myPREFERENCES =response.body().getCases();
                SharedPreferences.Editor myedit = sharedpreferences.edit();
                myedit.putInt("data",myPREFERENCES);
                myedit.commit();
               // Toast.makeText(Main2Activity.this, String.valueOf(sharedpreferences.getInt("data",0)), Toast.LENGTH_SHORT).show();
                Date date2 = new Date(response.body().getUpdated());
                DateFormat formatter2 = new SimpleDateFormat("dd MMMM hh:mm aa");
                formatter2.setTimeZone(TimeZone.getTimeZone("UTC"));
                String dateFormatted2 = formatter2.format(date2);
                updateEgypt.setText(dateFormatted2);


            }

            @Override
            public void onFailure(Call<API> call, Throwable t) {

                Toast.makeText(Main2Activity.this, "Check your Connection", Toast.LENGTH_SHORT).show();
                Log.v("haoooooooo",t.getMessage());
            }
        });





    }



    public void connection2() {
        ProgressDialog progressDialog = new ProgressDialog(Main2Activity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Getting update..");
        progressDialog.show();

        ApiServer2.createService(ApiInterface.class).getapiAllGlobal().enqueue(new Callback<Api3>() {
            @Override
            public void onResponse(Call<Api3> call, Response<Api3> response) {
                progressDialog.dismiss();
                decimalFormat.setGroupingUsed(true);
                decimalFormat.setGroupingSize(3);

                totalcase_num.setText(decimalFormat.format(response.body().getCases()));
                totalcase_num_new.setText("+"+decimalFormat.format(response.body().getTodayCases()));
                death_num.setText(decimalFormat.format(response.body().getDeaths()));
                death_num_new.setText("+"+decimalFormat.format(response.body().getTodayDeaths()));
                recovery_num.setText(decimalFormat.format(response.body().getRecovered()));

                Date date = new Date(response.body().getUpdated());
                DateFormat formatter = new SimpleDateFormat("dd MMMM hh:mm aa");
                formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
                String dateFormatted = formatter.format(date);
                updateGlobal.setText(dateFormatted);

            }

            @Override
            public void onFailure(Call<Api3> call, Throwable t) {
                progressDialog.dismiss();
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
        connection2();
    }


    public void moreinfo(View view) {
        Intent intent = new Intent(this,Main4Activity.class);
        startActivity(intent);
    }


    public void more_global_info(View view) {
        Intent intent = new Intent(this,Main5Activity.class);
        startActivity(intent);
    }

    private void sendNotification(String messageTitle,String messageBody) {
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        Uri soundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            @SuppressLint("WrongConstant")
            NotificationChannel notificationChannel=new NotificationChannel("my_notification","n_channel",NotificationManager.IMPORTANCE_MAX);
            notificationChannel.setDescription("description");
            notificationChannel.setName("Channel Name");
            assert notificationManager != null;
            notificationManager.createNotificationChannel(notificationChannel);
        }


        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.corona_circle)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.egypt_circle))
                .setContentTitle(messageTitle)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(soundUri)
                .setContentIntent(pendingIntent)
                .setDefaults(Notification.DEFAULT_ALL)
                .setOnlyAlertOnce(true)
                .setChannelId("my_notification")
                .setColor(Color.parseColor("#3F5996"));

        //.setProgress(100,50,false);
        assert notificationManager != null;
        int m = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
        notificationManager.notify(m, notificationBuilder.build());
    }
}
