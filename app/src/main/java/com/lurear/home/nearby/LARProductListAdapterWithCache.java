// ProductListAdapterWithCache.java
package com.lurear.home.nearby;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lurear.R;
import com.lurear.app.LARCommon;
import com.lurear.home.LARHomeActivity;

import java.util.List;



public class LARProductListAdapterWithCache extends ArrayAdapter<LARProduct> {
    private final Context mContext;
    List<LARProduct> mylist;

    public LARProductListAdapterWithCache(Activity  _context, List<LARProduct> _mylist) {
        super(_context, R.layout.fragment_lurenearbylist_cell, _mylist);

        mContext = _context;
        this.mylist = _mylist;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LARProduct product = getItem(position);

        final ProductViewHolder holder;
        if (convertView == null) {
            convertView = new LinearLayout(getContext());
//            String inflater = Context.LAYOUT_INFLATER_SERVICE;
//            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
//            convertView = vi.inflate(R.layout.lurenearbylist_cell, parent, false);
            LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflater.inflate(R.layout.fragment_lurenearbylist_cell, null,true);
            //
            holder = new ProductViewHolder();
            holder.img = (ImageView)convertView.findViewById(R.id.image);
            holder.title = (TextView)convertView.findViewById(R.id.title);
            holder.imgring=(ImageView)convertView.findViewById(R.id.imagering);
            holder.imglayout=(ImageView)convertView.findViewById(R.id.imagelayout);
            //
            convertView.setTag(holder);
        }
        else{
            holder = (ProductViewHolder) convertView.getTag();
        }

        int resId = getContext().getResources().getIdentifier(product.title.toLowerCase(), "drawable", getContext().getPackageName());
        //
        holder.populate(product,resId);

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LARCommon.getlastview() != null && v!= LARCommon.getlastview()){
                    LinearLayout parent = (LinearLayout) (LARCommon.getlastview().getParent().getParent());
//                    parent.findViewById(R.id.image).setVisibility(View.GONE);
                    ImageView lastimglayout=(ImageView)parent.findViewById(R.id.imagelayout);
                    ImageView lastimgring=(ImageView)parent.findViewById(R.id.imagering);
                    lastimglayout.setImageDrawable(null);
                    lastimgring.setImageResource(R.drawable.ic_ring);
                }

                LARCommon.setlastview(v);
                Drawable drawable = holder.imgring.getDrawable();
                if (drawable !=null ){
                    holder.imglayout.setImageResource(R.drawable.ic_png_layout);
                    holder.imgring.setImageDrawable(null);
                }
                else {
                    Intent intent = new Intent(mContext, LARHomeActivity.class);
                    mContext.startActivity(intent);
                }
            }
        });
        //
        return convertView;
    }

    static class ProductViewHolder {
        public ImageView img;
        public TextView title;
        public ImageView imgring;
        public ImageView imglayout;
        void populate(LARProduct p,int resId) {
            title.setText(p.title);
            img.setImageResource(resId);

                imgring.setImageResource(R.drawable.ic_ring);

        }
    }

}