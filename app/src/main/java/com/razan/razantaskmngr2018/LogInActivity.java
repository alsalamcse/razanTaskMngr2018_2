package com.razan.razantaskmngr2018;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity {
    private EditText etEmail1,etPassword1;
    private Button btnSignIn,btnSignUp, btnLogIn;
    private FirebaseAuth auth;
    private FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etEmail1=findViewById(R.id.etEmail1);
        etPassword1=findViewById(R.id.etPassword1);
        btnSignIn=findViewById(R.id.btnSignIn);
        btnSignUp=findViewById(R.id.btnSignUp);
        btnLogIn=findViewById(R.id.btnLogIn);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHundler();
            }
        });

       btnLogIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

             dataHundler1();
           }
       });





      btnSignUp.setOnClickListener(new View.OnClickListener() {
          @Override
           public void onClick(View view) {
              Intent intent=new Intent(LogInActivity.this,SignUp.class);
               startActivity(intent);
           }
       });



    }

    private void dataHundler1() {
        boolean isok= true; // if alla the fields filled well
        String email= etEmail1.getText().toString();
        String password= etPassword1.getText().toString();

        if (email.length()<4 || email.indexOf('@')<0 || email.indexOf('.')<0)
        {
            etEmail1.setError("worng Email");
            isok=false;
        }
        if (password.length()<8) {
            etPassword1.setError(" Have to be at least 8 char");
            isok = false;
        }
        if (isok)
        {
            signIn1(email, password);

        }

    }
    private void signIn1(String email, String passw){
        auth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(LogInActivity.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()) {
                    Toast.makeText(LogInActivity.this, "logIn Successful", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(LogInActivity.this,StudentPage1.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(LogInActivity.this, "LogIn failed"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();

                }

            }
        });
    }

    private void dataHundler() {
       boolean isok= true; // if alla the fields filled well
        String email= etEmail1.getText().toString();
        String password= etPassword1.getText().toString();

        if (email.length()<4 || email.indexOf('@')<0 || email.indexOf('.')<0)
        {
            etEmail1.setError("worng Email");
            isok=false;
        }
        if (password.length()<8) {
            etPassword1.setError(" Have to be at least 8 char");
            isok = false;
        }
        if (isok)
        {
            signIn(email, password);

        }

    }
    private void signIn(String email, String passw){
        auth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(LogInActivity.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()) {
                    Toast.makeText(LogInActivity.this, "logIn Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LogInActivity.this, MainTabsActivity.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                   Toast.makeText(LogInActivity.this, "LogIn failed"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                   task.getException().printStackTrace();

                }

            }
        });
    }
}
