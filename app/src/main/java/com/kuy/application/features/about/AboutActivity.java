package com.kuy.application.features.about;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kuy.application.R;
import com.kuy.application.features.BaseActivity;

public class AboutActivity extends BaseActivity<AboutPresenter, AboutView>
        implements AboutView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    @NonNull
    @Override
    public AboutPresenter providePresenter() {
        return new AboutPresenter();
    }
}
