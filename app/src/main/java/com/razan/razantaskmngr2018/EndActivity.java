package com.razan.razantaskmngr2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.razan.razantaskmngr2018.ui.end.EndFragment;

public class EndActivity extends AppCompatActivity {
    private TextView textView,textView2;
    private ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_activity);
        textView = findViewById(R.id.textView);
        textView2= findViewById(R.id.textView2);
         imageButton= findViewById(R.id.imageButton
         );

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, EndFragment.newInstance())
                    .commitNow();
        }
    }
}
