package com.razan.razantaskmngr2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.razan.razantaskmngr2018.data.MyParking;
import com.razan.razantaskmngr2018.data.MyTask;

import java.util.ArrayList;
import java.util.List;

public class ExitActivity extends AppCompatActivity {

    private TextView tvPrice;
    private TextView etPrice2;
    private Button btnOut;
    FirebaseAuth auth;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);
        tvPrice = findViewById(R.id.tvPrice);
        etPrice2 = findViewById(R.id.etPrice2);
        btnOut = findViewById(R.id.btnOut);




        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               readParkingInfo();
                Toast.makeText(ExitActivity.this, "Exit Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ExitActivity.this, EndActivity.class);
                startActivity(intent);
            }
        });




    }

    public void AddPrice(){


        DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
        String id= auth.getUid();
       // reference.child("MyParking").child(id).child("cost").setValue(etPrice2.getText());

                etPrice2.setText((CharSequence) reference.child("MyParking").child(id).child("cost").setValue(etPrice2.getText()));

    }
    private List<MyParking> readParkingInfo()
    {
        final ArrayList<MyParking> parking=new ArrayList<>();
        //reference to the database root
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference();

        reference.child("MyParking").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                for (DataSnapshot d : dataSnapshot.getChildren())
                {
                    MyParking value=d.getValue(MyParking.class);
                    parking.add(value);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return parking;
    }

}
