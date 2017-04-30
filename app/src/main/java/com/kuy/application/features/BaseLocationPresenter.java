package com.kuy.application.features;

import android.support.annotation.NonNull;

import com.kuy.application.location.EasyLocationRequest;

/**
 * Created by gilang on 4/30/17.
 */

public class BaseLocationPresenter<V extends BaseLocationView> extends BasePresenter<V> {
    @Override
    protected void onAttachView(@NonNull V view) {
        super.onAttachView(view);
    }

    protected void requestSingleLocationFix(EasyLocationRequest easyLocationRequest) {
        getView().requestSingleLocationFix(easyLocationRequest);
    }
}
