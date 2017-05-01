package com.kuy.application.features.trainmap;

import android.location.Location;

import com.kuy.application.features.BaseLocationView;
import com.kuy.application.models.RouteResult;
import com.kuy.application.models.Station;

import net.grandcentrix.thirtyinch.callonmainthread.CallOnMainThread;

/**
 * Created by gilang on 5/2/17.
 */

public interface TrainView extends BaseLocationView {

    @CallOnMainThread
    void updateResult(RouteResult result);

    @CallOnMainThread
    double getLatitude();

    @CallOnMainThread
    double getLongitude();

    @CallOnMainThread
    double getDestinationLatitude();

    @CallOnMainThread
    double getDestinationLongitude();

    @CallOnMainThread
    void updateCurrentLocation(Location location);

    @CallOnMainThread
    void updateDepartureStation(Station start);

    @CallOnMainThread
    void updateDestinationStation(Station goal);
}
