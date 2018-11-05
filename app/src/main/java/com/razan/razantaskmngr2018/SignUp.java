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

public class SignUp extends AppCompatActivity {
    private EditText etFirst,etLast,Phone,etEmail,etPassword;
    private Button btnSave;
    //1.add of auth to project
    //2.
    private FirebaseUser user;// user
    private FirebaseAuth auth;// to establish sign in sign up



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
                dataHandler();

            }
        });
        //3.
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();//
    }
    // get email and passwor from the field and try to create new user
    private void dataHandler()
    {
        boolean isOk= true; // if alla the fields filled well
        String email= etEmail.getText().toString();
        String password= etPassword.getText().toString();
        String fName= etFirst.getText().toString();
        String lName= etLast.getText().toString();
        String phone= Phone.getText().toString();
        boolean isok = false;
        if (email.length()<4 || email.indexOf('@')<0 || email.indexOf('.')<0)
        {
            etEmail.setError("worng Email");
            isok=false;
        }
        if (password.length()<8)
        {
            etPassword.setError(" Have to be at least 8 char");
            isok=false;
        }
        if (isok)
        {
            creatAcount(email, password);
        }

    }
    //4.

    /**
     * create firebase user using email & password
     * @param email user email
     * @param passw user password
     */
    private void creatAcount (String email,String passw){
        auth.createUserWithEmailAndPassword(email, passw).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(SignUp.this, "Authemtication successful", Toast.LENGTH_SHORT).show();
                    //updateUserProfil(task.getResult().getUser());
                    finish();
                }
                else
                {
                    Toast.makeText(SignUp.this,"Authemtication failed."+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();

                }
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUp.this,LogInActivity.class);
                startActivity(i);
            }
        });
    }
}
