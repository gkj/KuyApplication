package com.kuy.application.features.splashscreen;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;

import com.kuy.application.features.BasePresenter;
import com.kuy.application.features.login.LoginActivity;
import com.kuy.application.features.main.MainActivity;
import com.kuy.application.util.Preferences;
import com.kuy.application.util.StationUtil;

/**
 * Created by gilang on 4/29/17.
 */

public class SplashscreenPresenter extends BasePresenter<SplashscreenView> {

    // Splash screen timer
    private static final int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onAttachView(@NonNull SplashscreenView view) {
        super.onAttachView(view);

        try {


            new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                @Override
                public void run() {
                    if (this != null && getBaseActivity() != null) {
                        Preferences.getInstance().setContext(getActivity());
                        if (isViewAttached()) {
                            if (Preferences.getInstance().isUserLogin()) {
                                navigateTo(MainActivity.class);
                            } else {
                                navigateTo(LoginActivity.class);
                            }
                        }
                    }

                    // close activity
                    finishActivity();
                }
            }, SPLASH_TIME_OUT);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
