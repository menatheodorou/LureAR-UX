package com.lurear.model;

import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

import com.lurear.R;

import java.util.ArrayList;
        import java.util.HashMap;

public class LARCheckInOutAdapter extends ArrayAdapter<LARCheckInOutModel> {

    ArrayList<LARCheckInOutModel> checkItemsList = new ArrayList<>();

    public LARCheckInOutAdapter(Context context, int textViewResourceId, ArrayList<LARCheckInOutModel> objects) {
        super(context, textViewResourceId, objects);
        checkItemsList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.fragment_list_cell, null);
        TextView txtViewName = (TextView) v.findViewById(R.id.textViewName);
        txtViewName.setText(checkItemsList.get(position).getName());
        TextView txtViewDate = (TextView) v.findViewById(R.id.textViewDate);
        txtViewDate.setText(checkItemsList.get(position).getDate());
        TextView txtViewTime = (TextView) v.findViewById(R.id.textViewTime);
        txtViewTime.setText(checkItemsList.get(position).getTime());
        return v;

    }

}
