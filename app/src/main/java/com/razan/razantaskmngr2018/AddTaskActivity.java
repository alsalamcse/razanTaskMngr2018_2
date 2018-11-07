package com.razan.razantaskmngr2018;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.sql.Date;
import java.util.Calendar;

public class AddTaskActivity extends AppCompatActivity {
    private EditText etTitle,etTask,etDueDate;
    private TextView tvImportant,tvNeseccery;
    private SeekBar sB1,sB2;
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
        sB1=findViewById(R.id.sB1);
        sB2=findViewById(R.id.sB2);
        btSave=findViewById(R.id.btnSave);
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
        int important1=sB1.getProgress();
        int neseccery1=sB2.getProgress();

        boolean isok = false;
        if (title.length()<4 || title.indexOf('@')<0 || title.indexOf('.')<0)
        {
           etTitle.setError("worng Email");
            isok=false;
        }
        if (task.length()<8)
        {
            etTask.setError(" Have to be at least 8 char");
            isok=false;
        }
    }
}
