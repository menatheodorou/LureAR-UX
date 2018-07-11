package com.lurear.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.gpit.android.logger.RemoteLogger;
import com.lurear.R;
import com.lurear.base.LARBaseActivity;
import com.lurear.home.LARAddCheckInActivity;
import com.lurear.home.LARAddGeoFenceActivity;
import com.lurear.home.LARHomeActivity;
import com.lurear.model.LARAddGeoFenceAdapter;
import com.lurear.model.LARAddGeoFenceModel;
import com.lurear.model.LARAddInterestAdapter;
import com.lurear.model.LARAddInterestsModel;
import com.lurear.model.LARProfileMapAdapter;
import com.lurear.model.LARProfileMapModel;
import com.splunk.mint.Mint;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.inflate;
import static java.security.AccessController.getContext;

/**
 * Created by administrator on 8/6/17.
 */

public class LARCommon {
    private static LARCommon instance;
    private static View mlastview;
    private static int selectinterest,interest1,interest2,interest3;
    public static LARCommon getInstance() {
        if (instance == null) {
            instance = new LARCommon();
        }

        return instance;
    }
    public static int getInterest1(){
        return interest1;
    }
    public static int getInterest2(){
        return interest2;
    }
    public static int getInterest3(){
        return interest3;
    }
    public static int getSelectinterest(){
        return selectinterest;
    }
    public static void setInterest1(int x){
        interest1=x;
    }
    public static void setInterest2(int x){
        interest2=x;
    }
    public static void setInterest3(int x){
        interest3=x;
    }
    public static void setSelectinterest(int x){
        selectinterest=x;
    }
    public static View getlastview(){
        return mlastview;
    }
    public static void setlastview(View v){
        mlastview=v;
    }
    private LARCommon() {
    }

    public void handleError(LARBaseActivity activity, String tag, Exception e) {
        RemoteLogger.e(tag, e.getLocalizedMessage());
        Mint.logException(e);
        e.printStackTrace();

        if (activity != null) {
            Toast.makeText(activity, R.string.something_went_wrong, Toast.LENGTH_LONG).show();

            activity.finish();
        }
    }

    public void updateStatusBarColor(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return;
        }

        Window window = activity.getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(activity.getColor(R.color.colorPrimary));
    }

    private static Dialog pickerDistanceDialog;
    private static Dialog pickerProfileMapViewDialog;
    private static Dialog pickerAddGeoFenceDialog;
    private static Dialog pickerHomeGeoFenceDialog;
    private static Dialog pickerAddInterestsDialog;
    private static Dialog pickerAddCheckInDialog;

    public static void hidePickerProfileMapViewDialog() {
        if (pickerProfileMapViewDialog != null && pickerProfileMapViewDialog.isShowing()) {
            pickerProfileMapViewDialog.hide();
            pickerProfileMapViewDialog = null;
        }
    }


    public static void hidePickerDialog() {
        if (pickerDistanceDialog != null && pickerDistanceDialog.isShowing()) {
            pickerDistanceDialog.hide();
            pickerDistanceDialog = null;
        }
    }

    public static void hideAddGeoFencePickerDialog() {
        if (pickerAddGeoFenceDialog != null && pickerAddGeoFenceDialog.isShowing()) {
            pickerAddGeoFenceDialog.hide();
            pickerAddGeoFenceDialog = null;
        }
    }

    public static void hideHomeGeoFencePickerDialog() {
        if (pickerHomeGeoFenceDialog != null && pickerHomeGeoFenceDialog.isShowing()) {
            pickerHomeGeoFenceDialog.hide();
            pickerHomeGeoFenceDialog = null;
        }
    }
    public static void hideAddInterestsPickerDialog() {
        if (pickerAddInterestsDialog != null && pickerAddInterestsDialog.isShowing()) {
            pickerAddInterestsDialog.hide();
            pickerAddInterestsDialog = null;
        }
    }
    public static void hideShowCheckInPickerDialog(){
        if (pickerAddCheckInDialog != null && pickerAddCheckInDialog.isShowing()) {
            pickerAddCheckInDialog.hide();
            pickerAddCheckInDialog = null;
        }
    }

    public static void showDistancePickerDialog(final Context context) {
        hidePickerDialog();

        pickerDistanceDialog = new Dialog(context);

        pickerDistanceDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pickerDistanceDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pickerDistanceDialog.setContentView(R.layout.activity_save_distance_picker);
        pickerDistanceDialog.setCancelable(true);
        pickerDistanceDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pickerDistanceDialog.getWindow().setGravity(Gravity.BOTTOM);
        pickerDistanceDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button btnCL = (Button)pickerDistanceDialog.findViewById(R.id.btSave);
        btnCL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hidePickerDialog();
            }
        });

        pickerDistanceDialog.show();
    }

    public static void showProfileMapViewPickerDialog(final Context context) {

        pickerProfileMapViewDialog = new Dialog(context);

        pickerProfileMapViewDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pickerProfileMapViewDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pickerProfileMapViewDialog.setContentView(R.layout.activity_mapview_profile);
        pickerProfileMapViewDialog.setCancelable(true);
        pickerProfileMapViewDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pickerProfileMapViewDialog.getWindow().setGravity(Gravity.CENTER);
        final ImageView mapcheckin=(ImageView) pickerProfileMapViewDialog.findViewById(R.id.ic_map_checkin);
        final ImageView archeckin=(ImageView) pickerProfileMapViewDialog.findViewById(R.id.ic_ar_checkin);
        mapcheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapcheckin.setImageResource(R.mipmap.ic_bt_map_checkin);
                archeckin.setImageResource(R.mipmap.ic_bt_ar_checkin);
            }
        });
        archeckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapcheckin.setImageResource(R.mipmap.ic_bt_map_checkin_dis);
                archeckin.setImageResource(R.mipmap.ic_bt_ar_checkin_dis);
            }
        });
        pickerProfileMapViewDialog.show();
//        Button btnCL = (Button)pickerProfileMapViewDialog.findViewById(R.id.btSave);
//        btnCL.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                hidePickerProfileMapViewDialog();
//            }
//        });

        ListView itemsList;
        ArrayList<LARProfileMapModel> profileInterestItemList=new ArrayList<>();
        itemsList = (ListView) pickerProfileMapViewDialog.findViewById(R.id.profileMapListView);
        profileInterestItemList.add(new LARProfileMapModel("Long Drives"));
        profileInterestItemList.add(new LARProfileMapModel("Try New Food"));
        profileInterestItemList.add(new LARProfileMapModel("Soccer"));

        LARProfileMapAdapter myAdapter=new LARProfileMapAdapter(context,R.layout.fragment_profilemap_cell,profileInterestItemList);
        itemsList.setAdapter(myAdapter);
//        pickerProfileMapViewDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
//            @Override
//            public void onDismiss(DialogInterface dialogInterface) {
//                Intent intent = new Intent(context, LARAddGeoFenceActivity.class);
//                context.startActivity(intent);
//            }
//        });
    }

    public static void showAddGeoFenceDialog(final Context context) {
        //hideAddGeoFencePickerDialog();

        pickerAddGeoFenceDialog = new Dialog(context);
        pickerAddGeoFenceDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pickerAddGeoFenceDialog.setContentView(R.layout.activity_add_geo_fence);
        pickerAddGeoFenceDialog.setCancelable(true);
        pickerAddGeoFenceDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pickerAddGeoFenceDialog.getWindow().setGravity(Gravity.BOTTOM);
        pickerAddGeoFenceDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button btnCL = (Button)pickerAddGeoFenceDialog.findViewById(R.id.btSave);
        btnCL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showHomeGeoFenceDialog(context);
                hideAddGeoFencePickerDialog();

            }
        });

        pickerAddGeoFenceDialog.show();
    }

    public static void showCheckInLocationDialog(final Context context) {

        pickerAddCheckInDialog = new Dialog(context);
        pickerAddCheckInDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pickerAddCheckInDialog.setContentView(R.layout.fragment_check_in_location);
        pickerAddCheckInDialog.setCancelable(true);
        pickerAddCheckInDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pickerAddCheckInDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pickerAddCheckInDialog.getWindow().setGravity(Gravity.BOTTOM);
        Button btnCL = (Button)pickerAddCheckInDialog.findViewById(R.id.btSave);
        btnCL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hideShowCheckInPickerDialog();
                Intent intent = new Intent(context, LARHomeActivity.class);
                context.startActivity(intent);
            }
        });
        pickerAddCheckInDialog.show();
        pickerAddCheckInDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {

                Intent intent = new Intent(context, LARAddCheckInActivity.class);
                context.startActivity(intent);
            }
        });
    }

    public static void showHomeGeoFenceDialog(final Context context) {

        pickerHomeGeoFenceDialog = new Dialog(context);
        pickerHomeGeoFenceDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pickerHomeGeoFenceDialog.setContentView(R.layout.activity_home_geo_fence);
        pickerHomeGeoFenceDialog.setCancelable(true);
        pickerHomeGeoFenceDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pickerHomeGeoFenceDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pickerHomeGeoFenceDialog.getWindow().setGravity(Gravity.BOTTOM);
        Button btnCL = (Button)pickerHomeGeoFenceDialog.findViewById(R.id.btSave);
        btnCL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hideHomeGeoFencePickerDialog();
                Intent intent = new Intent(context, LARAddGeoFenceActivity.class);
                context.startActivity(intent);
            }
        });
        Button btnAddNewGeoFence = (Button)pickerHomeGeoFenceDialog.findViewById(R.id.btAddNewGeoFence);
        btnAddNewGeoFence.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hideHomeGeoFencePickerDialog();
            }
        });
        pickerHomeGeoFenceDialog.show();
    }

    public static void showAddInterestsDialog(final Context context, final int select) {

        List<LARAddInterestsModel> itemList = new ArrayList<>();
        RecyclerView recyclerView;
        LARAddInterestAdapter mAdapter;
        Activity activity = (context instanceof Activity) ? (Activity) context : null;

        final ImageView img1=(ImageView)activity.findViewById(R.id.btn1);
        final ImageView img2=(ImageView)activity.findViewById(R.id.btn2);
        final ImageView img3=(ImageView)activity.findViewById(R.id.btn3);
        pickerAddInterestsDialog = new Dialog(context);
        pickerAddInterestsDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pickerAddInterestsDialog.setContentView(R.layout.activity_add_interest);
        pickerAddInterestsDialog.setCancelable(true);
        pickerAddInterestsDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pickerAddInterestsDialog.getWindow().setGravity(Gravity.BOTTOM);
        pickerAddInterestsDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnCL = (Button)pickerAddInterestsDialog.findViewById(R.id.btAddInterests);
        btnCL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (select==0) {
                    if (getSelectinterest() != 0) {
                        if (getInterest1() == 0) {
                            setInterest1(getSelectinterest());
                            int resId = context.getResources().getIdentifier("ic_num" + Integer.toString(getSelectinterest()), "drawable", context.getPackageName());
                            img1.setImageResource(resId);
                        } else if (getInterest2() == 0 && getInterest1() != getSelectinterest()) {
                            int resId = context.getResources().getIdentifier("ic_num" + Integer.toString(getSelectinterest()), "drawable", context.getPackageName());
                            img2.setImageResource(resId);
                            setInterest2(getSelectinterest());
                        } else if (getInterest3() == 0 && getInterest1() != getSelectinterest() && getInterest2() != getSelectinterest()) {
                            setInterest3(getSelectinterest());
                            int resId = context.getResources().getIdentifier("ic_num" + Integer.toString(getSelectinterest()), "drawable", context.getPackageName());
                            img3.setImageResource(resId);
                            img3.setTag(getSelectinterest());
                        }
                    }
                }else if(select==1 && getInterest3() != getSelectinterest() && getInterest2() != getSelectinterest()){
                    int resId = context.getResources().getIdentifier("ic_num" + Integer.toString(getSelectinterest()), "drawable", context.getPackageName());
                    img1.setImageResource(resId);
                    setInterest1(getSelectinterest());
                }else if (select==2 && getInterest1() != getSelectinterest() && getInterest3() != getSelectinterest()){
                    int resId = context.getResources().getIdentifier("ic_num" + Integer.toString(getSelectinterest()), "drawable", context.getPackageName());
                    img2.setImageResource(resId);
                    setInterest2(getSelectinterest());
                }else if (select==3 && getInterest1() != getSelectinterest() && getInterest2() != getSelectinterest()){
                    int resId = context.getResources().getIdentifier("ic_num" + Integer.toString(getSelectinterest()), "drawable", context.getPackageName());
                    img3.setImageResource(resId);
                    setInterest3(getSelectinterest());
                }
                else if (select==4 && getSelectinterest() != 0){
                    int resId = context.getResources().getIdentifier("ic_num" + Integer.toString(getSelectinterest()), "drawable", context.getPackageName());
                    img1.setImageResource(resId);
                    setInterest1(getSelectinterest());
                    img2.setImageResource(R.mipmap.ic_add);
                    img1.setTag(getSelectinterest());
                }else if (select==5 && getSelectinterest() != 0 && getInterest1() != getSelectinterest()){
                    int resId = context.getResources().getIdentifier("ic_num" + Integer.toString(getSelectinterest()), "drawable", context.getPackageName());
                    img2.setImageResource(resId);
                    setInterest2(getSelectinterest());
                    img3.setImageResource(R.mipmap.ic_add);
                    img2.setTag(getSelectinterest());
                }
                hideAddInterestsPickerDialog();
            }

        });
        pickerAddInterestsDialog.show();

        recyclerView = (RecyclerView) pickerAddInterestsDialog.findViewById(R.id.addInterestItemRecyclerView);
        mAdapter = new LARAddInterestAdapter(itemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        LARAddInterestsModel interestsModel = new LARAddInterestsModel("Soccer", false, 1);
        itemList.add(interestsModel);
        interestsModel = new LARAddInterestsModel("Gymming", false,2);
        itemList.add(interestsModel);
        interestsModel = new LARAddInterestsModel("Trying New Things", false,3);
        itemList.add(interestsModel);
        interestsModel = new LARAddInterestsModel("Foodie", false,4);
        itemList.add(interestsModel);
        interestsModel = new LARAddInterestsModel("BasketBall", false,5);
        itemList.add(interestsModel);
        interestsModel = new LARAddInterestsModel("Long Drives", false,6);
        itemList.add(interestsModel);
        interestsModel = new LARAddInterestsModel("Partying", false,7);
        itemList.add(interestsModel);
        interestsModel = new LARAddInterestsModel("Night Outs", false,8);
        itemList.add(interestsModel);
        interestsModel = new LARAddInterestsModel("Trekking", false,9);
        itemList.add(interestsModel);
        interestsModel = new LARAddInterestsModel("Swimming", false,10);
        itemList.add(interestsModel);

        mAdapter.notifyDataSetChanged();
//        recyclerView.addOnItemTouchListener(new LARRecyclerTouchListener(context.getApplicationContext(), recyclerView, new LARRecyclerTouchListener.ClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                Movie movie = movieList.get(position);
//                Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onLongClick(View view, int position) {
//
//            }
//        }));
    }
    //Show Confirm Dialog
    public static void showConfirmDialog(final Context context) {

        pickerAddInterestsDialog = new Dialog(context);
        pickerAddInterestsDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pickerAddInterestsDialog.setContentView(R.layout.activity_confirm);
        pickerAddInterestsDialog.setCancelable(true);
        pickerAddInterestsDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pickerAddInterestsDialog.getWindow().setGravity(Gravity.BOTTOM);
        pickerAddInterestsDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnCL = (Button)pickerAddInterestsDialog.findViewById(R.id.btConfirm);
        btnCL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hideAddInterestsPickerDialog();

                Intent intent = new Intent(context, LARAddGeoFenceActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                context.startActivity(intent);
            }
        });

        Button btnEm = (Button)pickerAddInterestsDialog.findViewById(R.id.btempty);
        btnEm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hideAddInterestsPickerDialog();
                Intent intent = new Intent(context, LARAddGeoFenceActivity.class);
                context.startActivity(intent);
            }
        });
        pickerAddInterestsDialog.show();

        ListView itemsList;
        ArrayList<LARAddGeoFenceModel> addItemsList=new ArrayList<>();
        itemsList = (ListView) pickerAddInterestsDialog.findViewById(R.id.confirmItemListView);
        addItemsList.add(new LARAddGeoFenceModel("Home"));
        addItemsList.add(new LARAddGeoFenceModel("Gym"));
        addItemsList.add(new LARAddGeoFenceModel("Home2"));
        addItemsList.add(new LARAddGeoFenceModel("Find Resi"));
        addItemsList.add(new LARAddGeoFenceModel("Office"));

        LARAddGeoFenceAdapter myAdapter=new LARAddGeoFenceAdapter(context,R.layout.fragment_add_geofence_cell,addItemsList);
        itemsList.setAdapter(myAdapter);
        pickerAddInterestsDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                Intent intent = new Intent(context, LARAddGeoFenceActivity.class);
                context.startActivity(intent);
            }
        });
    }
}
