package com.razan.razantaskmngr2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ExitActivity extends AppCompatActivity {

    private TextView tvPrice;
    private EditText etPrice2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);
        tvPrice=findViewById(R.id.tvPrice);
        etPrice2=findViewById(R.id.etPrice2);


    }
}
