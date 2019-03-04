package com.razan.razantaskmngr2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.razan.razantaskmngr2018.data.MyParking;

public class StatisticsActivity extends AppCompatActivity {
    private EditText etcost,etCode,etName,etAddress;
    private ImageButton imSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        etcost=findViewById(R.id.etcost);
        etCode=findViewById(R.id.etCode);
        etName=findViewById(R.id.etName);
        etAddress=findViewById(R.id.etAddress);
        imSave=findViewById(R.id.imSave);


        imSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });



    }

    private void dataHandler() {
        String name=etName.getText().toString();
        String adress=etAddress.getText().toString();
        String cost=etcost.getText().toString(); //ast5raj als3er
        double d=Double.parseDouble(cost); //t7wel mn string ldouble
        String code=etCode.getText().toString(); //ast5raj als3er
        double c=Double.parseDouble(code); //t7wel mn string ldouble
        MyParking parking=new MyParking();
        parking.setName(name);
        parking.setAddress(adress);
        parking.setCost(cost);
        parking.setCost(code);
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference();
        String key=reference.child("MyParking").push().getKey();
        



    }
}
