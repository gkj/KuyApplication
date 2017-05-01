package com.kuy.application.features.restaurant;

import android.location.Location;

import com.kuy.application.features.BaseLocationView;

import net.grandcentrix.thirtyinch.callonmainthread.CallOnMainThread;

import rx.Observable;

/**
 * Created by gilang on 4/29/17.
 */

public interface RestaurantView extends BaseLocationView {

    @CallOnMainThread
    Observable<Void> onNearbyRestaurantButtonClicked();

    @CallOnMainThread
    Observable<Void> onCheapestRestaurantButtonClicked();
}
