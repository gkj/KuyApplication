package com.kuy.application.features.hoteldetail;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.kuy.application.features.BasePresenter;
import com.kuy.application.features.map.MapActivity;
import com.kuy.application.features.trainmap.TrainActivity;
import com.kuy.application.util.Constant;

import rx.functions.Action1;

/**
 * Created by gilang on 4/29/17.
 */

public class HotelDetailPresenter extends BasePresenter<HotelDetailView> {

    @Override
    protected void onAttachView(@NonNull HotelDetailView view) {
        super.onAttachView(view);

        registerObservable(getView().onShowMapButtonClicked().subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                Intent intent = getBaseIntent(MapActivity.class);
                intent.putExtra(Constant.SELECTED_HOTEL, getView().getSelectedHotel());
                navigateTo(intent);
            }
        }));

        registerObservable(getView().onTrainSuggestionButtonClicked().subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                Intent intent = getBaseIntent(TrainActivity.class);
                intent.putExtra(Constant.SELECTED_HOTEL, getView().getSelectedHotel());
                navigateTo(intent);
            }
        }));
    }
}
