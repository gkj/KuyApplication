
package com.kuy.application.features.hotel;

import com.kuy.application.features.BaseLocationView;
import com.kuy.application.features.BaseView;

import net.grandcentrix.thirtyinch.callonmainthread.CallOnMainThread;

import rx.Observable;

/**
 * Created by gilang on 4/29/17.
 */

public interface HotelView extends BaseLocationView {

    @CallOnMainThread
    Observable<Void> onNearbyHotelButtonClicked();

    @CallOnMainThread
    Observable<Void> onCheapestHotelButtonClicked();


}
