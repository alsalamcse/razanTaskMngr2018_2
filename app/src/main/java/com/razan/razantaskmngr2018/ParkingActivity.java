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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ParkingActivity extends AppCompatActivity {
    private ListView lstPark;
    //private EditText etcost, etCode, etName, etAddress;
    private ImageButton imSave;



    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);
     //   etcost=findViewById(R.id.etcost);
    //   etCode=findViewById(R.id.etCode);
     // etName=findViewById(R.id.etName);
      //etAddress=findViewById(R.id.etAddress);
        imSave=findViewById(R.id.imSave);
     //   Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
     //   setSupportActionBar(toolbar);
     //   btnPark1 = findViewById(R.id.btnPark1);
      //  btnPark2 = findViewById(R.id.btnPark2);
     //   btnPark3 = findViewById(R.id.btnPark3);



    //    btnPark1.setOnClickListener(new View.OnClickListener() {
     //       @Override
     //       public void onClick(View view) {
      //          Intent i = new Intent(ParkingActivity.this,AddParkActivity.class);
      //          startActivity(i);

     //      }
     //   });
    //    btnPark2.setOnClickListener(new View.OnClickListener() {
      //      @Override
       //     public void onClick(View view) {
       //         Intent i = new Intent(ParkingActivity.this,AddParkActivity.class);
       //         startActivity(i);

       //     }
       // });
    //    btnPark3.setOnClickListener(new View.OnClickListener() {
      //      @Override
       //     public void onClick(View view) {
       //         Intent i = new Intent(ParkingActivity.this,AddParkActivity.class);
        //        startActivity(i);

       //     }
       // });
        private void getProfile()
        {
            DatabaseReference reference=FirebaseDatabase.getInstance().getReference();
            String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
            DatabaseReference databaseReference = reference;
            databaseReference.child("Myprofile");
            databaseReference.child(email.replace('.', '*'));
            final ValueEventListener valueEventListener = databaseReference.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    DataSnapshot d = dataSnapshot.getChildren().iterator().next();
//               //   MyProfile p=dataSnapshot.getValue(MyProfile.class);
//                    etName.setText(p.getName());
//                    etcost.setText(p.getcost());
//                    etCode.setText(p.getCode());
//                    etAddress.setText(p.getAddress());


                }


                FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()

                {
                    @Override
                    public void onClick (View view){
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent i = new Intent(getBaseContext(), AddParkActivity.class);
                    startActivity(i);
                }
                });
            };
        }
    }
}


