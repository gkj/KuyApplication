package com.kuy.application.features.hotel;

import android.location.Location;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.widget.Button;

import com.jakewharton.rxbinding.view.RxView;
import com.kuy.application.features.BaseLocationActivity;
import com.kuy.application.R;

import rx.Observable;

public class HotelActivity extends BaseLocationActivity<HotelPresenter, HotelView>
        implements HotelView {

    private Button nearbyHotelButton;
    private Button cheapestHotelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        initUI();
    }

    private void initUI() {
        nearbyHotelButton = (Button) findViewById(R.id.button_nearby_hotel);
        cheapestHotelButton = (Button) findViewById(R.id.button_cheapest_hotel);
    }

    @NonNull
    @Override
    public HotelPresenter providePresenter() {
        return new HotelPresenter();
    }

    @Override
    public Observable<Void> onNearbyHotelButtonClicked() {
        return RxView.clicks(nearbyHotelButton);
    }

    @Override
    public Observable<Void> onCheapestHotelButtonClicked() {
        return RxView.clicks(cheapestHotelButton);
    }

    @Override
    public void onLocationReceived(Location location) {
        super.onLocationReceived(location);
        stopLocationUpdates();
        getPresenter().onLocationReceived(location);
    }
}
