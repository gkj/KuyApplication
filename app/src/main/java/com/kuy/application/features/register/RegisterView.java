package com.kuy.application.features.register;

import com.kuy.application.features.BaseView;

import net.grandcentrix.thirtyinch.callonmainthread.CallOnMainThread;

import rx.Observable;

/**
 * Created by gilang on 5/9/17.
 */

public interface RegisterView extends BaseView {

    @CallOnMainThread
    String getUserName();

    @CallOnMainThread
    String getEmail();

    @CallOnMainThread
    String getPassword();

    @CallOnMainThread
    Observable<Void> onLoginButtonClicked();

    @CallOnMainThread
    Observable<Void> onRegisterButtonClicked();

    @CallOnMainThread
    void clearInput();
}
