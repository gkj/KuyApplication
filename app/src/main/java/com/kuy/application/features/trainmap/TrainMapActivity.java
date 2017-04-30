package com.kuy.application.features.trainmap;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kuy.application.R;
import com.kuy.application.features.BaseActivity;

public class TrainMapActivity extends BaseActivity<TrainMapPresenter, TrainMapView>
        implements TrainMapView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_map);
    }

    @NonNull
    @Override
    public TrainMapPresenter providePresenter() {
        return new TrainMapPresenter();
    }
}
