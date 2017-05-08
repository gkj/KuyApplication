package com.kuy.application.features.login;

import com.kuy.application.features.BaseView;

import net.grandcentrix.thirtyinch.TiView;
import net.grandcentrix.thirtyinch.callonmainthread.CallOnMainThread;
import net.grandcentrix.thirtyinch.distinctuntilchanged.DistinctUntilChanged;

import rx.Observable;

/**
 * Created by gilang on 4/26/17.
 */

public interface LoginView extends BaseView {

    @CallOnMainThread
    Observable<Void> onLoginButtonClicked();

    @CallOnMainThread
    Observable<Void> onRegisterButtonClicked();

    @CallOnMainThread
    String getEmail();

    @CallOnMainThread
    String getPassword();
}
