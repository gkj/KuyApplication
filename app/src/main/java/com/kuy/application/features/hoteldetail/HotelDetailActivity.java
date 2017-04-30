package com.kuy.application.features.hoteldetail;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.kuy.application.R;
import com.kuy.application.features.BaseActivity;
import com.kuy.application.models.Hotel;
import com.kuy.application.util.Constant;
import com.squareup.picasso.Picasso;

import rx.Observable;

public class HotelDetailActivity extends BaseActivity<HotelDetailPresenter, HotelDetailView>
        implements HotelDetailView {

    private ImageView image;
    private TextView nameTextView;
    private TextView priceTextView;
    private TextView addressTextView;
    private TextView cityTextView;
    private TextView postalCodeTextView;
    private Button showMapButton;

    private Hotel selectedHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detail);
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
        selectedHotel = (Hotel) intent.getParcelableExtra(Constant.SELECTED_HOTEL);

        if (selectedHotel != null) {
            nameTextView.setText(selectedHotel.getName());
            priceTextView.setText("MYR " + selectedHotel.getPrice());
            addressTextView.setText(selectedHotel.getAddress());
            cityTextView.setText(selectedHotel.getCity());
            postalCodeTextView.setText(selectedHotel.getPostalCode());

            Picasso.with(this).load(selectedHotel.getImage()).into(image);
        }
    }

    @NonNull
    @Override
    public HotelDetailPresenter providePresenter() {
        return new HotelDetailPresenter();
    }

    @Override
    public Observable<Void> onShowMapButtonClicked(){
        return RxView.clicks(showMapButton);
    }

    @Override
    public Hotel getSelectedHotel() {
        return selectedHotel;
    }
}
