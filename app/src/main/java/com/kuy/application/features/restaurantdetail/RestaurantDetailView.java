package com.kuy.application.features.restaurantdetail;

import com.kuy.application.features.BaseView;
import com.kuy.application.models.Restaurant;

import net.grandcentrix.thirtyinch.callonmainthread.CallOnMainThread;

import rx.Observable;

/**
 * Created by gilang on 4/30/17.
 */

public interface RestaurantDetailView extends BaseView {

    @CallOnMainThread
    Observable<Void> onShowMapButtonClicked();

    @CallOnMainThread
    Observable<Void> onTrainSuggestionButtonClicked();

    @CallOnMainThread
    Restaurant getSelectedRestaurant();

    @CallOnMainThread
    double getLatitude();

    @CallOnMainThread
    double getLongitude();
}
