package com.kuy.application.features.profile;

import android.support.annotation.MainThread;

import com.kuy.application.features.BaseView;

import net.grandcentrix.thirtyinch.callonmainthread.CallOnMainThread;
import net.grandcentrix.thirtyinch.distinctuntilchanged.DistinctUntilChanged;

/**
 * Created by gilang on 4/29/17.
 */

public interface ProfileView extends BaseView {

    @CallOnMainThread
    @DistinctUntilChanged
    void changeName(String name);

    @CallOnMainThread
    @DistinctUntilChanged
    void changeEmail(String email);
}
