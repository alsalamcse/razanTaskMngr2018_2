package com.razan.razantaskmngr2018.taskfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.razan.razantaskmngr2018.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TasksHistoryFragment extends Fragment {


    public TasksHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks_history, container, false);
    }

}
