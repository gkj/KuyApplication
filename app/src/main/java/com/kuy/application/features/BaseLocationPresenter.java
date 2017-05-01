package com.kuy.application.features;

import android.location.Location;
import android.support.annotation.NonNull;

import com.google.android.gms.location.LocationRequest;
import com.kuy.application.location.EasyLocationRequest;
import com.kuy.application.location.EasyLocationRequestBuilder;

/**
 * Created by gilang on 4/30/17.
 */

public abstract class BaseLocationPresenter<V extends BaseLocationView> extends BasePresenter<V> {

    private LocationRequest locationRequest = new LocationRequest()
            .setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY)
            .setInterval(5000)
            .setFastestInterval(5000);

    private EasyLocationRequest easyLocationRequest = new EasyLocationRequestBuilder()
            .setLocationRequest(locationRequest)
            .setFallBackToLastLocationTime(3000)
            .build();

    @Override
    protected void onAttachView(@NonNull V view) {
        super.onAttachView(view);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getView() != null)
            getView().stopLocationUpdates();
    }

    public abstract void onLocationReceived(Location location);

    public void requestCurrentLocation() {
        getView().requestSingleLocationFix(easyLocationRequest);
    }

}
