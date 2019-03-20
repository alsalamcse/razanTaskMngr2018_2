package com.razan.razantaskmngr2018.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.razan.razantaskmngr2018.R;

public class parkAdaptor extends ArrayAdapter<MyParking> {
    public parkAdaptor( Context context, int resource) {
        super(context, resource);
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent)
    {
        if (convertView==null)
            convertView=LayoutInflater.from(getContext())
                    .inflate(R.layout.park_item,parent,false);

//to get current data object
        MyParking m=getItem(position);//return data object number "position"
//get referances for eact item at the xml ui
        TextView tvName=convertView.findViewById(R.id.tvName);
        TextView tvCost=convertView.findViewById(R.id.tvCost);
        TextView tvCode=convertView.findViewById(R.id.tvCode);
        TextView tvAddress=convertView.findViewById(R.id.tvAddress);
       // ImageButton imageButton=convertView.findViewById(R.id.imageButton);
//put the data of the object on the view
        tvName.setText(m.getName());
        tvAddress.setText(m.getAddress());
        tvCode.setText(m.getCode());
        tvCost.setText(""+ m.getCost());
        return convertView;
    }
}
