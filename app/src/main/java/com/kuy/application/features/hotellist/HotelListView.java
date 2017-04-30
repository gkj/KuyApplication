package com.kuy.application.features.hotellist;

import com.kuy.application.features.BaseView;
import com.kuy.application.models.Hotel;

import net.grandcentrix.thirtyinch.callonmainthread.CallOnMainThread;

import java.util.List;

/**
 * Created by gilang on 4/29/17.
 */

public interface HotelListView extends BaseView {

    @CallOnMainThread
    void updateDataset(List<Hotel> hotels);

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
