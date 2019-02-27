package com.razan.razantaskmngr2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.razan.razantaskmngr2018.ui.end.EndFragment;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, EndFragment.newInstance())
                    .commitNow();
        }
    }
}
