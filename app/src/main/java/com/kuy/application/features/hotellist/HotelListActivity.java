package com.kuy.application.features.hotellist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.kuy.application.R;
import com.kuy.application.features.BaseActivity;
import com.kuy.application.features.hoteldetail.HotelDetailActivity;
import com.kuy.application.models.Hotel;
import com.kuy.application.util.Constant;

import java.util.ArrayList;
import java.util.List;

public class HotelListActivity extends BaseActivity<HotelListPresenter, HotelListView>
        implements HotelListView {

    private RecyclerView recyclerView;
    private HotelListAdapter adapter;
    private MaterialDialog progressDialog;
    private int sortMode;
    private double latitude;
    private double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);
        initUI();
    }

    private void initUI() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_hotel);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        adapter = new HotelListAdapter(this, new ArrayList<Hotel>(), new HotelListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Hotel item) {
                Intent intent = getBaseIntent(HotelDetailActivity.class);
                intent.putExtra(Constant.SELECTED_HOTEL, item);
                intent.putExtra(Constant.LATITUDE, latitude);
                intent.putExtra(Constant.LONGITUDE, longitude);
                navigateTo(intent);
            }
        });

        recyclerView.setAdapter(adapter);

        sortMode = getIntent().getIntExtra(Constant.HOTEL_MODE, Constant.HOTEL_MODE_DISTANCE);
        if (sortMode == Constant.HOTEL_MODE_DISTANCE) {
            latitude = getIntent().getDoubleExtra(Constant.LATITUDE, Constant.NO_COORDINATE);
            longitude = getIntent().getDoubleExtra(Constant.LONGITUDE, Constant.NO_COORDINATE);
            setTitle("Nearby Hotel");
        }
        else {
            setTitle("Cheapest Hotel");
        }
    }

    @NonNull
    @Override
    public HotelListPresenter providePresenter() {
        return new HotelListPresenter();
    }

    @Override
    public void updateDataset(List<Hotel> hotels) {
        adapter.updateDataset(hotels);
    }

    @Override
    public void showProgressDialog() {
        progressDialog = getProgressDialog("Please wait...");
        progressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        progressDialog.dismiss();
    }

    @Override
    public int getSortMode() {
        return sortMode;
    }

    @Override
    public double getLatitude() {
        return latitude;
    }

    @Override
    public double getLongitude() {
        return longitude;
    }
}
