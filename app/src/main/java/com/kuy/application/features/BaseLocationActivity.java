package com.kuy.application.features;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.kuy.application.location.EasyLocationDelegate;
import com.kuy.application.location.EasyLocationListener;
import com.kuy.application.location.EasyLocationRequest;

/**
 * Created by gilang on 4/30/17.
 */

public abstract class BaseLocationActivity<P extends BaseLocationPresenter<V>, V extends BaseLocationView> extends BaseActivity<P, V>
        implements BaseLocationView, EasyLocationListener {

    private EasyLocationDelegate easyLocationDelegate;

    protected Location getLastKnownLocation() {
        return easyLocationDelegate.getLastKnownLocation();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        easyLocationDelegate = new EasyLocationDelegate(this,this);
        easyLocationDelegate.onCreate();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        easyLocationDelegate.onActivityResult(requestCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        easyLocationDelegate.onRequestPermissionsResult(requestCode, grantResults);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        easyLocationDelegate.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        easyLocationDelegate.stopLocationUpdates();
    }

    @Override
    public void requestLocationUpdates(EasyLocationRequest easyLocationRequest) {
        easyLocationDelegate.requestLocationUpdates(easyLocationRequest);
    }

    @Override
    public void requestSingleLocationFix(EasyLocationRequest easyLocationRequest) {
        easyLocationDelegate.requestSingleLocationFix(easyLocationRequest);
    }

    @Override
    public void stopLocationUpdates() {
        easyLocationDelegate.stopLocationUpdates();
    }

    @Override
    public void onLocationPermissionGranted() {

    }

    @Override
    public void onLocationPermissionDenied() {

    }

    @Override
    public void onLocationReceived(Location location) {
        getPresenter().onLocationReceived(location);
    }

    @Override
    public void onLocationProviderEnabled() {

    }

    @Override
    public void onLocationProviderDisabled() {

    }
}
