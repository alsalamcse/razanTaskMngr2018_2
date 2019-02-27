package com.razan.razantaskmngr2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private Button btExit;
    private Button btEnter;
    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btEnter=findViewById(R.id.btEnter);
        btExit=findViewById(R.id.btExit);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        if(auth.getCurrentUser()!=null && auth.getCurrentUser().get!=null)
        {
            Intent i = new Intent(MainActivity.this, FinishActivity.class);
            startActivity(i);
        }




        btEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, EnterClientActivity.class);
                startActivity(i);

            }
        });

        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ExitActivity.class);
                startActivity(i);

            }
        });
    }
}
