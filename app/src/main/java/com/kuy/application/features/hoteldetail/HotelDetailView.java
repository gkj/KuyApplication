package com.kuy.application.features.hoteldetail;

import com.kuy.application.features.BaseView;
import com.kuy.application.models.Hotel;

import net.grandcentrix.thirtyinch.callonmainthread.CallOnMainThread;

import rx.Observable;

/**
 * Created by gilang on 4/29/17.
 */

public interface HotelDetailView extends BaseView {

    @CallOnMainThread
    Observable<Void> onShowMapButtonClicked();

    @CallOnMainThread
    Observable<Void> onTrainSuggestionButtonClicked();

    @CallOnMainThread
    Hotel getSelectedHotel();

    @CallOnMainThread
    double getLatitude();

    @CallOnMainThread
    double getLongitude();
}
