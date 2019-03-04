package com.razan.razantaskmngr2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class EnterClientActivity extends AppCompatActivity {
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_client);
        btnSave = findViewById(R.id.btnSave);

        Calendar cal = Calendar.getInstance();//alse3h





        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EnterClientActivity.this, EnterClientActivity.class);
                startActivity(i);
            }
        });
    }
}





