package com.kuy.application.features.main;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.kuy.application.features.BasePresenter;
import com.kuy.application.features.about.AboutActivity;
import com.kuy.application.features.hotel.HotelActivity;
import com.kuy.application.features.login.LoginActivity;
import com.kuy.application.features.profile.ProfileActivity;
import com.kuy.application.features.restaurant.RestaurantActivity;
import com.kuy.application.util.Constant;
import com.kuy.application.util.Preferences;

import rx.functions.Action1;

/**
 * Created by gilang on 4/29/17.
 */

public class MainPresenter extends BasePresenter<MainView> {

    @Override
    protected void onAttachView(@NonNull MainView view) {
        super.onAttachView(view);

        registerObservable(getView().onHotelButtonClicked().subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                //hotel button clicked
                navigateTo(HotelActivity.class);
            }
        }));

        registerObservable(getView().onRestaurantButtonClicked().subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                //restaurant button clicked
                navigateTo(RestaurantActivity.class);
            }
        }));

        registerObservable(getView().onAboutButtonClicked().subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                //about button clicked
                navigateTo(AboutActivity.class);
            }
        }));

        registerObservable(getView().onProfileButtonClicked().subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                //profile button clicked
                navigateTo(ProfileActivity.class);
            }
        }));

        registerObservable(getView().onLogoutButtonClicked().subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                //logout button clicked
                Preferences.getInstance().setContext(getActivity());
                Preferences.getInstance().userLoggedOut();
                navigateTo(LoginActivity.class);
                finishActivity();
            }
        }));

        //request permission
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    Constant.MY_PERMISSIONS_REQUEST_LOCATIONS);
        }
    }


}
