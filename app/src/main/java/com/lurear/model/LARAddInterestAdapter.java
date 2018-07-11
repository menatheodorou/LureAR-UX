package com.lurear.model;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.lurear.R;
import com.lurear.app.LARCommon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by security on 10/21/2017.
 */

public class LARAddInterestAdapter extends RecyclerView.Adapter<LARAddInterestAdapter.MyViewHolder> {

    private List<LARAddInterestsModel> interestList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView itemName;
        public CheckBox lastcheck;

        public MyViewHolder(View view) {
            super(view);
            itemName = (TextView) view.findViewById(R.id.textViewInterestItem);
            lastcheck=(CheckBox) view.findViewById(R.id.checkSwim);
        }
    }


    public LARAddInterestAdapter(List<LARAddInterestsModel> interestList) {
        this.interestList = interestList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_add_interest_cell, parent, false);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                RecyclerView recyclerView = (RecyclerView) parent.findViewById(R.id.addInterestItemRecyclerView);
                if (LARCommon.getSelectinterest()!=0) {
                    View lastviw = recyclerView.findViewHolderForAdapterPosition(LARCommon.getSelectinterest()-1).itemView;
                    CheckBox lastcheckBox=(CheckBox) lastviw.findViewById(R.id.checkSwim);
                    if(lastcheckBox.isChecked()){
                        lastcheckBox.setChecked(false);
                    }else{
                        lastcheckBox.setChecked(true);
                    }
                }
                 CheckBox checkBoxSwim = (CheckBox)v.findViewById(R.id.checkSwim) ;
                Object tagValue = v.getTag();
               String position =  tagValue.toString();
                LARCommon.setSelectinterest(Integer.parseInt(position)+1);

                if(checkBoxSwim.isChecked()){
                    checkBoxSwim.setChecked(false);
                }else{
                    checkBoxSwim.setChecked(true);
                }
            }
        });
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (LARCommon.getSelectinterest()!=0 && position==LARCommon.getSelectinterest()-1){
            holder.lastcheck.setChecked(true);
        }
        LARAddInterestsModel interestsModel = interestList.get(position);
        holder.itemView.setTag(position);
        holder.itemName.setText(interestsModel.getName());
    }

    @Override
    public int getItemCount() {
        return interestList.size();
    }
}

