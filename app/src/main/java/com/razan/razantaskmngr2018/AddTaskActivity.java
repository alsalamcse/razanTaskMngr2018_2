package com.razan.razantaskmngr2018;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.razan.razantaskmngr2018.data.MyTask;

import java.util.Date;
import java.util.Calendar;
import java.util.IllegalFormatCodePointException;

public class AddTaskActivity extends AppCompatActivity {
    private EditText etTitle,etTask,etDueDate;
    private TextView tvImportant,tvNeseccery;
    private SeekBar skbrNeseccery,skbarImportant;
    private Button btSave, btDatePicker;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        etTitle=findViewById(R.id.etTitle);
        etTask=findViewById(R.id.etTask);
        etDueDate=findViewById(R.id.etDueDate);
        tvImportant=findViewById(R.id.tvImportant);
        tvNeseccery=findViewById(R.id.tvNeseccery);
        skbrNeseccery=findViewById(R.id.skbrNeseccery);
        skbarImportant=findViewById(R.id.skbrNeseccery);
        btSave=findViewById(R.id.btSave);
        btDatePicker=findViewById(R.id.btDatePicker);


        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataHandler();

            }
        });

    }
    public void onClick(View view){
        if (view==btDatePicker){
            final Calendar c=Calendar.getInstance();
            mYear=c.get(Calendar.YEAR);
            mMonth=c.get(Calendar.MONTH);
            mDay=c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                    etDueDate.setText(dayOfMonth+"-"+monthOfYear+"-"+year);
                }
            }, mYear, mMonth , mDay);
            datePickerDialog.show();


        }
    }

    private void dataHandler(){

        boolean isOk= true; // if alla the fields filled well
        String title= etTitle.getText().toString();
        String task= etTask.getText().toString();
        String dueDate= etDueDate.getText().toString();
        String important=tvImportant.getText().toString();
        String neseccery = tvNeseccery.getText().toString();
        int important1=skbrNeseccery.getProgress();
        int neseccery1=skbarImportant.getProgress();

        boolean isok = false;
        if (title.length()==0)
        {
           etTitle.setError("Title can not be empty");
            isok=false;
        }
        if (task.length()==0)
        {
            etTask.setError(" Task can not be empty");
            isok=false;
        }
        if (isOk)
        {
            final MyTask task1=new MyTask();
            task1.setCreatedAt(new Date());
            task1.setDueDate(new Date(dueDate));
            task1.setText(task);
            task1.setTitle(title);
            task1.setImportant(important1);
            task1.setNecessary(neseccery1);

            FirebaseAuth auth=FirebaseAuth.getInstance();
            task1.setOwner(auth.getCurrentUser().getEmail());
            DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
            String key=reference.child("myTask").push().getKey();
            task1.setKey(key);
            reference.child("myTask").child(key).setValue(task1).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(AddTaskActivity.this, "ADD SUCCEFUL",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(AddTaskActivity.this, "ADD faild",Toast.LENGTH_SHORT).show();
                    }

                }
            });







        }
    }
}
