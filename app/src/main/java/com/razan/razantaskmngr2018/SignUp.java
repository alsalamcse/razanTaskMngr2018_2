package com.razan.razantaskmngr2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {
    private EditText etFirst,etLast,Phone,etEmail,etPassword;
    private Button btnSave;
    FirebaseUser user;// user
    FirebaseAuth auth;// to establish sign in sign up



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etFirst=findViewById(R.id.etFirst);
        etLast=findViewById(R.id.etLast);
        Phone=findViewById(R.id.phone);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btnSave=findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUp.this,LogInActivity.class);
                startActivity(i);
            }
        });
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();//
    }
}
