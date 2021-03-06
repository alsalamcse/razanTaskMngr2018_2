package com.razan.razantaskmngr2018;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.razan.razantaskmngr2018.data.Client;
import com.razan.razantaskmngr2018.data.MyParking;

import java.util.Calendar;

public class EnterClientActivity extends AppCompatActivity {
    private Button btnSave;
    private TextView etCar, etVisa, etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_client);
        btnSave = findViewById(R.id.btnSave);
        etCar = findViewById(R.id.etCar);
        etVisa = findViewById(R.id.etVisa);
        etName = findViewById(R.id.etName);


        Calendar cal = Calendar.getInstance();//alse3h


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });
    }

    private void dataHandler() {
       // String number = etCar.getText().toString();
       // String Visa = etVisa.getText().toString();
        if (etName.getText().length() != 0 &&etCar.getText().length()!= 0 && etVisa.getText().length() != 0 ) {
            String Name = etName.getText().toString(); //ast5raj als3er
            int n = Integer.parseInt(etCar.getText().toString());//t7wel mn string ldouble
            int v = Integer.parseInt(etVisa.getText().toString());
            //double c=Double.parseDouble(code); //t7wel mn string ldouble
            Client client = new Client();
            client.setNumber(n);
            client.setName(Name);
            client.setVisa(v);
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
            String key = reference.child("Client").push().getKey();
            reference.child("Client").child(key).setValue(client).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(EnterClientActivity.this, "add successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(EnterClientActivity.this, MainActivity.class);
                        startActivity(i);

                    } else {
                        Toast.makeText(EnterClientActivity.this, "add faild", Toast.LENGTH_SHORT).show();
                    }


                }
            });
        }else{
            etName.setError("Enter Name");
            etCar.setError("Enter Num");
            etVisa.setError("Enter Visa");
        }
    }
}









