package com.lurear.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lurear.R;
import com.lurear.home.geofence.LARPlusGeoFenceActivity;

import java.util.ArrayList;

/**
 * Created by security on 10/25/2017.
 */


public class LARProfileMapAdapter  extends ArrayAdapter<LARProfileMapModel> {

    ArrayList<LARProfileMapModel> profileInterestItemsList = new ArrayList<>();

    public LARProfileMapAdapter(Context context, int textViewResourceId, ArrayList<LARProfileMapModel> objects) {
        super(context, textViewResourceId, objects);
        profileInterestItemsList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.fragment_profilemap_cell, null);
//        v.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(final View v) {
//                Intent intent = new Intent(getContext(), LARPlusGeoFenceActivity.class);
//                getContext().startActivity(intent);
//            }
//        });
        TextView txtViewName = (TextView) v.findViewById(R.id.textViewProfileInterestItem);
        txtViewName.setText(profileInterestItemsList.get(position).getName());

        return v;

    }

}