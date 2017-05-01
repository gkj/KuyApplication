package com.kuy.application.features.restaurant;

import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.jakewharton.rxbinding.view.RxView;
import com.kuy.application.R;
import com.kuy.application.features.BaseActivity;
import com.kuy.application.features.BaseLocationActivity;

import rx.Observable;

public class RestaurantActivity extends BaseLocationActivity<RestaurantPresenter, RestaurantView>
        implements RestaurantView {

    private Button nearbyRestaurantButton;
    private Button cheapestRestaurantButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        initUI();
    }

    private void initUI() {
        nearbyRestaurantButton = (Button) findViewById(R.id.button_nearby_restaurant);
        cheapestRestaurantButton = (Button) findViewById(R.id.button_cheapest_restaurant);
    }

    @NonNull
    @Override
    public RestaurantPresenter providePresenter() {
        return new RestaurantPresenter();
    }

    @Override
    public Observable<Void> onNearbyRestaurantButtonClicked() {
        return RxView.clicks(nearbyRestaurantButton);
    }

    @Override
    public Observable<Void> onCheapestRestaurantButtonClicked() {
        return RxView.clicks(cheapestRestaurantButton);
    }
}
