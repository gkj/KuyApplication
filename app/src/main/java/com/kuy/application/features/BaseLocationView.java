package com.kuy.application.features;

import com.kuy.application.location.EasyLocationRequest;

import net.grandcentrix.thirtyinch.callonmainthread.CallOnMainThread;

/**
 * Created by gilang on 4/30/17.
 */

public interface BaseLocationView extends BaseView {

    @CallOnMainThread
    void requestLocationUpdates(EasyLocationRequest easyLocationRequest);

    @CallOnMainThread
    void requestSingleLocationFix(EasyLocationRequest easyLocationRequest);

    @CallOnMainThread
    void stopLocationUpdates();
}
