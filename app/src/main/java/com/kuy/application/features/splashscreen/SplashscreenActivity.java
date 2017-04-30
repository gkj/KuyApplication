package com.kuy.application.features.splashscreen;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;

import com.kuy.application.R;
import com.kuy.application.features.BaseActivity;
import com.kuy.application.features.login.LoginActivity;
import com.kuy.application.util.Preferences;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashscreenActivity extends BaseActivity<SplashscreenPresenter, SplashscreenView>
        implements SplashscreenView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
    }

    @NonNull
    @Override
    public SplashscreenPresenter providePresenter() {
        return new SplashscreenPresenter();
    }
}
