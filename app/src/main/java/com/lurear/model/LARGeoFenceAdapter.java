package com.lurear.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.lurear.R;
import com.lurear.home.LARHomeSideMenuActivity;
import com.lurear.home.geofence.LARGeoFenceActivity;
import com.lurear.home.geofence.LARPlusGeoFenceActivity;

import java.util.ArrayList;

/**
 * Created by security on 10/22/2017.
 */

public class LARGeoFenceAdapter  extends ArrayAdapter<LARGeoFenceModel> {

    ArrayList<LARGeoFenceModel> geoItemsList = new ArrayList<>();

    public LARGeoFenceAdapter(Context context, int textViewResourceId, ArrayList<LARGeoFenceModel> objects) {
        super(context, textViewResourceId, objects);
        geoItemsList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.fragment_geofence_list_cell, null);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(getContext(), LARPlusGeoFenceActivity.class);
                getContext().startActivity(intent);
            }
        });
        TextView txtViewName = (TextView) v.findViewById(R.id.textViewGeoFenceName);
        txtViewName.setText(geoItemsList.get(position).getName());
        TextView txtViewDate = (TextView) v.findViewById(R.id.textViewGeoStreetName);
        txtViewDate.setText(geoItemsList.get(position).getDate());
        TextView txtViewTime = (TextView) v.findViewById(R.id.textViewGeoMetre);
        txtViewTime.setText(geoItemsList.get(position).getTime());
        return v;

    }

}
