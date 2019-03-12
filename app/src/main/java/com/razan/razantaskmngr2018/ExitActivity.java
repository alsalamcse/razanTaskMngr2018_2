package com.razan.razantaskmngr2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ExitActivity extends AppCompatActivity {

    private TextView tvPrice;
    private EditText etPrice2;
    private Button btnOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);
        tvPrice=findViewById(R.id.tvPrice);
        etPrice2=findViewById(R.id.etPrice2);
        btnOut=findViewById(R.id.btnOut);


        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ExitActivity.this, "Exit Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ExitActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });


    }
}
