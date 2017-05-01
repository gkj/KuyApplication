package com.kuy.application.features;

import android.app.Activity;
import android.content.Intent;

import com.afollestad.materialdialogs.MaterialDialog;
import com.kuy.application.features.main.MainActivity;

import net.grandcentrix.thirtyinch.TiPresenter;
import net.grandcentrix.thirtyinch.rx.RxTiPresenterSubscriptionHandler;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action1;


/**
 * Created by gilang on 4/26/17.
 */

public abstract class BasePresenter<V extends BaseView> extends TiPresenter<V>{

    // add the subscription helper to your presenter
    private RxTiPresenterSubscriptionHandler rxHelper = new RxTiPresenterSubscriptionHandler(this);
    private MaterialDialog progressDialog;

    protected void registerObservable(Observable observable, Observer observer) {
        rxHelper.manageSubscription(observable.subscribe(observer));
    }

    protected void registerObservable(Subscription subscription) {
        rxHelper.manageSubscription(subscription);
    }

    protected Activity getActivity() {
        return getView().getActivity();
    }

    protected BaseActivity getBaseActivity() {
        return getView().getBaseActivity();
    }

    protected void finishActivity() {
        getView().finishActivity();
    }

    protected <T> void navigateTo(Class<T> clazz) {
        getView().navigateTo(clazz);
    }

    protected <T> void navigateTo(Intent intent) {
        getView().navigateTo(intent);
    }

    protected <T> Intent getBaseIntent(Class<T> clazz) {
        return getView().getBaseIntent(clazz);
    }

    protected void showMessage(String message) {
        getView().showMessage(message);
    }

    protected void showProgressDialog(String message) {
        if (progressDialog != null && !progressDialog.isCancelled())
            progressDialog.dismiss();

        progressDialog = getView().getProgressDialog(message);
        progressDialog.show();
    }

    protected void hideProgressDialog(){
        if (progressDialog != null && !progressDialog.isCancelled())
            progressDialog.dismiss();
    }
}
