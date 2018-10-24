package com.razan.razantaskmngr2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class AddTaskActivity extends AppCompatActivity {
    private EditText etTitle,etTask,etDueDate;
    private TextView tvImportant,tvNeseccery;
    private SeekBar sB1,sB2;
    private Button btSave, btDatePicker;

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

            }
        });
        btDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
