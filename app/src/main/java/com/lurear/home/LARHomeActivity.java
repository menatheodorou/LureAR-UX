package com.lurear.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.lurear.R;
import com.lurear.app.LARCommon;
import com.lurear.base.LARBaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LARHomeActivity extends LARBaseActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {
    @BindView(R.id.btHomeSide)
    ImageView mIBHomeSide;

    @BindView(R.id.btHomePin)
    ImageView mIBHomePin;

    @BindView(R.id.btSelectGeoFence)
    ImageView mIBSelectGeoFence;
    private GoogleMap mMap;
    private Marker myMarker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(this);
        // Add a marker in Sydney and move the camera
        LatLng exammarker = new LatLng(21, 57);
        View marker = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.fragment_marker, null);
        //ImageView imgmarker=(ImageView)findViewById(R.id.img_marker);

        myMarker=mMap.addMarker(new
                MarkerOptions().position(exammarker).title("Selena").icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker))));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(exammarker));

    }
    @Override
    public boolean onMarkerClick(final Marker marker) {

        if (marker.equals(myMarker))
        {
            //handle click here
            LARCommon.showProfileMapViewPickerDialog(LARHomeActivity.this);
        }
        return true;
    }
    public static Bitmap createDrawableFromView(Context context, View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);

        return bitmap;
    }
    @OnClick(R.id.btHomePin)
    void homePinClickListener() {
        LARCommon.showDistancePickerDialog(LARHomeActivity.this);
    }

    @OnClick(R.id.btSelectGeoFence)
    void selectGeoFenceClickListener() {
        Intent intent = new Intent(LARHomeActivity.this, LARSelectLocationActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter, R.anim.exit);
    }

    @OnClick(R.id.btHomeSide)
    void homeSideClickListener() {
        Intent intent = new Intent(LARHomeActivity.this, LARHomeSideMenuActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter, R.anim.exit);
    }
    @OnClick(R.id.btnHomeAr)
    void homeARClickListener() {
        Intent intent = new Intent(LARHomeActivity.this, LARAddCheckInActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean supportOffline() {
        return false;
    }
}
