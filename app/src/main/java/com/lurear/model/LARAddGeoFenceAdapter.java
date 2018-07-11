package com.lurear.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.lurear.R;

import java.util.ArrayList;

/**
 * Created by security on 10/21/2017.
 */



public class LARAddGeoFenceAdapter extends ArrayAdapter<LARAddGeoFenceModel> {
     View lastview;
    ArrayList<LARAddGeoFenceModel> itemslList = new ArrayList<>();

    public LARAddGeoFenceAdapter(Context context, int textViewResourceId, ArrayList<LARAddGeoFenceModel> objects) {
        super(context, textViewResourceId, objects);
        itemslList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.fragment_add_geofence_cell, null);
        TextView txtViewInterestItemName = (TextView) v.findViewById(R.id.textViewInterestItem);
        txtViewInterestItemName.setText(itemslList.get(position).getName());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (lastview!=null){
                    CheckBox lastcheckbox=lastview.findViewById(R.id.checkSwim);
                    lastcheckbox.setChecked(false);
                }
                CheckBox checkBoxSwim = (CheckBox)v.findViewById(R.id.checkSwim) ;

                if(checkBoxSwim.isChecked()){
                    checkBoxSwim.setChecked(false);
                }else{
                    checkBoxSwim.setChecked(true);
                }
                lastview=v;

            }
        });

        return v;

    }

}

