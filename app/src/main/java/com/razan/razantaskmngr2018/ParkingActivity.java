package com.razan.razantaskmngr2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.razan.razantaskmngr2018.data.MyParking;
import com.razan.razantaskmngr2018.data.parkAdaptor;

import java.util.ArrayList;

public class ParkingActivity extends AppCompatActivity {
    private ListView lstPark;

    private ImageButton imSave;
    private parkAdaptor parkAdaptor;


    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);

        lstPark = findViewById(R.id.lstPark);
        imSave = findViewById(R.id.imSave);
          // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
           //setSupportActionBar(toolbar);
        parkAdaptor=new parkAdaptor(getBaseContext(),R.layout.park_item);
        lstPark.setAdapter(parkAdaptor);

        getPark();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent i = new Intent(getBaseContext(), AddParkActivity.class);
                startActivity(i);
            }
        });
    }

    private final void getPark() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        reference.child("MyParking");
        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                parkAdaptor.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()) {
                    MyParking b = d.getValue(MyParking.class);
                    parkAdaptor.add(b);
                }
                parkAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(ParkingActivity.this, "onCancelled", Toast.LENGTH_SHORT).show();
            }


        });
    }
}





