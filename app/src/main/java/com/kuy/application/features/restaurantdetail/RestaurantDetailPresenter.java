package com.kuy.application.features.restaurantdetail;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.kuy.application.features.BasePresenter;
import com.kuy.application.features.map.MapActivity;
import com.kuy.application.features.trainmap.TrainActivity;
import com.kuy.application.util.Constant;

import rx.functions.Action1;

/**
 * Created by gilang on 4/30/17.
 */

public class RestaurantDetailPresenter extends BasePresenter<RestaurantDetailView> {
    @Override
    protected void onAttachView(@NonNull RestaurantDetailView view) {
        super.onAttachView(view);

        registerObservable(getView().onShowMapButtonClicked().subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                Intent intent = getBaseIntent(MapActivity.class);
                intent.putExtra(Constant.SELECTED_RESTAURANT, getView().getSelectedRestaurant());
                navigateTo(intent);
            }
        }));

        registerObservable(getView().onTrainSuggestionButtonClicked().subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                Intent intent = getBaseIntent(TrainActivity.class);
                intent.putExtra(Constant.SELECTED_RESTAURANT, getView().getSelectedRestaurant());
                intent.putExtra(Constant.LATITUDE, getView().getLatitude());
                intent.putExtra(Constant.LONGITUDE, getView().getLongitude());
                navigateTo(intent);
            }
        }));
    }
}
