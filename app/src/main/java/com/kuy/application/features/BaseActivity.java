package com.kuy.application.features;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.kuy.application.R;
import com.kuy.application.location.EasyLocationDelegate;
import com.kuy.application.location.EasyLocationListener;

import net.grandcentrix.thirtyinch.TiActivity;

/**
 * Created by gilang on 4/26/17.
 */

public abstract class BaseActivity<P extends BasePresenter<V>, V extends BaseView> extends TiActivity<P, V>
        implements BaseView {

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public BaseActivity getBaseActivity() {
        return this;
    }

    @Override
    public void showMessage(String message) {
        new MaterialDialog.Builder(this)
                .title(R.string.app_name)
                .content(message)
                .cancelable(false)
                .positiveText("OK")
                .show();
    }

    @Override
    public MaterialDialog getProgressDialog(String title, String message) {
        return new MaterialDialog.Builder(this)
                .title(title)
                .content(message)
                .progress(true, 0)
                .cancelable(false)
                .build();
    }

    @Override
    public MaterialDialog getProgressDialog(String message) {
        return getProgressDialog(getString(R.string.app_name), message);
    }

    @Override
    public void finishActivity(){
        finish();
    }

    @Override
    public <T> void navigateTo(Class<T> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    @Override
    public <T> void navigateTo(Intent intent) {
        startActivity(intent);
    }

    @Override
    public <T> Intent getBaseIntent(Class<T> clazz) {
        return new Intent(getBaseActivity(), clazz);
    }

    @Override
    public void showToast(String message) {
        showLongToast(message);
    }

    @Override
    public void showLongToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showShortToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
