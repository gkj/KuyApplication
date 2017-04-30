package com.kuy.application.features.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding.view.RxView;
import com.kuy.application.R;
import com.kuy.application.features.BaseActivity;
import com.kuy.application.features.login.LoginPresenter;
import com.kuy.application.features.login.LoginView;

import rx.Observable;

public class MainActivity extends BaseActivity<MainPresenter, MainView>
        implements MainView {

    private Button hotelButton;
    private Button restaurantButton;
    private Button trainMapButton;
    private Button aboutButton;
    private Button profileButton;
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        hotelButton = (Button) findViewById(R.id.button_hotel);
        restaurantButton = (Button) findViewById(R.id.button_restaurant);
        trainMapButton = (Button) findViewById(R.id.button_train_map);
        aboutButton = (Button) findViewById(R.id.button_about);
        profileButton = (Button) findViewById(R.id.button_profile);
        logoutButton = (Button) findViewById(R.id.button_logout);
    }

    @NonNull
    @Override
    public MainPresenter providePresenter() {
        return new MainPresenter();
    }

    @Override
    public Observable<Void> onHotelButtonClicked() {
        return RxView.clicks(hotelButton);
    }

    @Override
    public Observable<Void> onRestaurantButtonClicked() {
        return RxView.clicks(restaurantButton);
    }

    @Override
    public Observable<Void> onTrainMapButtonClicked() {
        return RxView.clicks(trainMapButton);
    }

    @Override
    public Observable<Void> onAboutButtonClicked() {
        return RxView.clicks(aboutButton);
    }

    @Override
    public Observable<Void> onProfileButtonClicked() {
        return RxView.clicks(profileButton);
    }

    @Override
    public Observable<Void> onLogoutButtonClicked() {
        return RxView.clicks(logoutButton);
    }
}
