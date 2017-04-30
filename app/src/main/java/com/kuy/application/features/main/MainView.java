package com.kuy.application.features.main;

import com.kuy.application.features.BaseView;

import net.grandcentrix.thirtyinch.callonmainthread.CallOnMainThread;

import rx.Observable;

/**
 * Created by gilang on 4/29/17.
 */

public interface MainView extends BaseView {

    @CallOnMainThread
    Observable<Void> onHotelButtonClicked();

    @CallOnMainThread
    Observable<Void> onRestaurantButtonClicked();

    @CallOnMainThread
    Observable<Void> onTrainMapButtonClicked();

    @CallOnMainThread
    Observable<Void> onAboutButtonClicked();

    @CallOnMainThread
    Observable<Void> onProfileButtonClicked();

    @CallOnMainThread
    Observable<Void> onLogoutButtonClicked();
}
