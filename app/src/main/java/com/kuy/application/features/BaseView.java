package com.kuy.application.features;

import android.app.Activity;
import android.content.Intent;

import com.afollestad.materialdialogs.MaterialDialog;

import net.grandcentrix.thirtyinch.TiView;
import net.grandcentrix.thirtyinch.callonmainthread.CallOnMainThread;

/**
 * Created by gilang on 4/26/17.
 */

public interface BaseView extends TiView {

    @CallOnMainThread
    Activity getActivity();

    @CallOnMainThread
    BaseActivity getBaseActivity();

    @CallOnMainThread
    void finishActivity();

    @CallOnMainThread
    <T> void navigateTo(Class<T> clazz);

    @CallOnMainThread
    <T> void navigateTo(Intent intent);

    @CallOnMainThread
    <T> Intent getBaseIntent(Class<T> clazz);

    @CallOnMainThread
    void showMessage(String message);

    @CallOnMainThread
    MaterialDialog getProgressDialog(String title, String message);

    @CallOnMainThread
    MaterialDialog getProgressDialog(String message);
}
