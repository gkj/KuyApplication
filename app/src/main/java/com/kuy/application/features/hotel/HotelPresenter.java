package com.kuy.application.features.hotel;

import android.content.Intent;
import android.location.Location;
import android.support.annotation.NonNull;

import com.google.android.gms.location.LocationRequest;
import com.kuy.application.features.BaseLocationPresenter;
import com.kuy.application.features.BasePresenter;
import com.kuy.application.features.hotellist.HotelListActivity;
import com.kuy.application.location.EasyLocationRequest;
import com.kuy.application.location.EasyLocationRequestBuilder;
import com.kuy.application.util.Constant;

import rx.functions.Action1;

/**
 * Created by gilang on 4/29/17.
 */

public class HotelPresenter extends BaseLocationPresenter<HotelView> {
    @Override
    protected void onAttachView(@NonNull HotelView view) {
        super.onAttachView(view);

        registerObservable(getView().onNearbyHotelButtonClicked().subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {

                showProgressDialog("Getting location...");

                requestCurrentLocation();
            }
        }));

        registerObservable(getView().onCheapestHotelButtonClicked().subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                Intent intent = getBaseIntent(HotelListActivity.class);
                intent.putExtra(Constant.HOTEL_MODE, Constant.HOTEL_MODE_PRICE);
                navigateTo(intent);
            }
        }));
    }

    @Override
    public void onLocationReceived(Location location) {
        if (isViewAttached()) {
            hideProgressDialog();
            Intent intent = getBaseIntent(HotelListActivity.class);
            intent.putExtra(Constant.HOTEL_MODE, Constant.HOTEL_MODE_DISTANCE);
            intent.putExtra(Constant.LATITUDE, location.getLatitude());
            intent.putExtra(Constant.LONGITUDE, location.getLongitude());
            navigateTo(intent);
        }
    }
}
