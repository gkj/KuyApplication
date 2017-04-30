package com.kuy.application.features.restaurantlist;

import com.kuy.application.features.BaseView;
import com.kuy.application.models.Restaurant;

import net.grandcentrix.thirtyinch.callonmainthread.CallOnMainThread;

import java.util.List;

/**
 * Created by gilang on 4/30/17.
 */

public interface RestaurantListView extends BaseView {
    @CallOnMainThread
    void updateDataset(List<Restaurant> restaurants);

    @CallOnMainThread
    void showProgressDialog();

    @CallOnMainThread
    void hideProgressDialog();

    @CallOnMainThread
    int getSortMode();

    @CallOnMainThread
    double getLatitude();

    @CallOnMainThread
    double getLongitude();
}
