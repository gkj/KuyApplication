package com.kuy.application.features.restaurantdetail;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.kuy.application.R;
import com.kuy.application.features.BaseActivity;
import com.kuy.application.models.Restaurant;
import com.kuy.application.util.Constant;
import com.squareup.picasso.Picasso;

import rx.Observable;

public class RestaurantDetailActivity extends BaseActivity<RestaurantDetailPresenter, RestaurantDetailView>
        implements RestaurantDetailView  {

    private ImageView image;
    private TextView nameTextView;
    private TextView priceTextView;
    private TextView addressTextView;
    private TextView cityTextView;
    private TextView postalCodeTextView;
    private Button showMapButton;

    private Restaurant selectedRestaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);
        initUI();
    }

    private void initUI(){
        image = (ImageView) findViewById(R.id.imageview_thumbnail);
        nameTextView = (TextView) findViewById(R.id.textview_name);
        priceTextView = (TextView) findViewById(R.id.textview_price);
        addressTextView = (TextView) findViewById(R.id.textview_address);
        cityTextView = (TextView) findViewById(R.id.textview_city);
        postalCodeTextView = (TextView) findViewById(R.id.textview_postal_code);
        showMapButton = (Button) findViewById(R.id.button_show_map);

        Intent intent = getIntent();
        selectedRestaurant = (Restaurant) intent.getParcelableExtra(Constant.SELECTED_RESTAURANT);

        if (selectedRestaurant != null) {
            nameTextView.setText(selectedRestaurant.getName());
            priceTextView.setText("MYR " + selectedRestaurant.getAverageCost());
            addressTextView.setText(selectedRestaurant.getAddress());
            cityTextView.setText(selectedRestaurant.getCity());
            postalCodeTextView.setText(selectedRestaurant.getPostalCode());

            Picasso.with(this).load(selectedRestaurant.getImage()).into(image);
        }
    }

    @NonNull
    @Override
    public RestaurantDetailPresenter providePresenter() {
        return new RestaurantDetailPresenter();
    }

    @Override
    public Observable<Void> onShowMapButtonClicked() {
        return RxView.clicks(showMapButton);
    }

    @Override
    public Restaurant getSelectedRestaurant() {
        return selectedRestaurant;
    }


}
