package com.kuy.application.features.restaurant;

import android.content.Intent;
import android.location.Location;
import android.support.annotation.NonNull;

import com.google.android.gms.location.LocationRequest;
import com.kuy.application.features.BaseLocationPresenter;
import com.kuy.application.features.restaurantlist.RestaurantListActivity;
import com.kuy.application.location.EasyLocationRequest;
import com.kuy.application.location.EasyLocationRequestBuilder;
import com.kuy.application.util.Constant;

import rx.functions.Action1;

/**
 * Created by gilang on 4/29/17.
 */

public class RestaurantPresenter extends BaseLocationPresenter<RestaurantView> {

    @Override
    protected void onAttachView(@NonNull RestaurantView view) {
        super.onAttachView(view);

        registerObservable(getView().onNearbyRestaurantButtonClicked().subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {

                showProgressDialog("Getting location...");

                LocationRequest locationRequest = new LocationRequest()
                        .setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY)
                        .setInterval(5000)
                        .setFastestInterval(5000);

                EasyLocationRequest easyLocationRequest = new EasyLocationRequestBuilder()
                        .setLocationRequest(locationRequest)
                        .setFallBackToLastLocationTime(3000)
                        .build();

                requestSingleLocationFix(easyLocationRequest);
            }
        }));

        registerObservable(getView().onCheapestRestaurantButtonClicked().subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                Intent intent = getBaseIntent(RestaurantListActivity.class);
                intent.putExtra(Constant.RESTAURANT_MODE, Constant.RESTAURANT_MODE_PRICE);
                navigateTo(intent);
            }
        }));
    }

    public void onLocationReceived(Location location) {
        if (isViewAttached()) {
            hideProgressDialog();
            Intent intent = getBaseIntent(RestaurantListActivity.class);
            intent.putExtra(Constant.RESTAURANT_MODE, Constant.RESTAURANT_MODE_DISTANCE);
            intent.putExtra(Constant.LATITUDE, location.getLatitude());
            intent.putExtra(Constant.LONGITUDE, location.getLongitude());
            navigateTo(intent);
        }
    }
}
