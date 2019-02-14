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
    private Button btnStudent;
    private Button btnCollage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        btnStudent = findViewById(R.id.btnStudent);
        btnCollage = findViewById(R.id.btnCollage);


        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });

        btnCollage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });


    }
}

//    @Override
//    protected void onResume() {
//        MyThread myThread=new MyThread();
//        myThread.start();
//        super.onResume();
//    }


   // public class MyThread extends Thread
//    {
    //    @Override
//        public void run() {
//            try {
//                sleep(3000);
//                Intent i=new Intent(getApplicationContext(),LogInActivity.class);
//                startActivity(i);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
