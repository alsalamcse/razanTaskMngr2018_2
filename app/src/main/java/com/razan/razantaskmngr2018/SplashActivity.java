package com.razan.razantaskmngr2018;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class SplashActivity extends AppCompatActivity {
    private Button btnClient;
    private Button btnPark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        btnClient = findViewById(R.id.btnClient);
        btnPark= findViewById(R.id.btnPark);


        btnClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });

        btnPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SplashActivity.this, LogInActivity.class);
                startActivity(i);
            }
        });


    }


    @Override
    protected void onResume() {
      MyThread myThread=new MyThread();
        myThread.start();
        super.onResume();
    }


   public class MyThread extends Thread
   {
       @Override
      public void run() {
           try {
                sleep(3000);
                Intent i=new Intent(SplashActivity.this,LogInActivity.class);
                startActivity(i);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }
    }
}
