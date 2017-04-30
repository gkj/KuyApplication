package com.kuy.application.features.restaurantlist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.kuy.application.R;
import com.kuy.application.features.BaseActivity;
import com.kuy.application.features.restaurantdetail.RestaurantDetailActivity;
import com.kuy.application.models.Restaurant;
import com.kuy.application.util.Constant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantListActivity extends BaseActivity<RestaurantListPresenter, RestaurantListView>
        implements RestaurantListView {

    private RecyclerView recyclerView;
    private RestaurantListAdapter adapter;
    private MaterialDialog progressDialog;
    private int sortMode;
    private double latitude;
    private double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        initUI();
    }

    private void initUI() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_restaurant);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        adapter = new RestaurantListAdapter(this, new ArrayList<Restaurant>(), new RestaurantListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Restaurant item) {
                Intent intent = getBaseIntent(RestaurantDetailActivity.class);
                intent.putExtra(Constant.SELECTED_RESTAURANT, item);
                navigateTo(intent);
            }
        });

        recyclerView.setAdapter(adapter);

        sortMode = getIntent().getIntExtra(Constant.RESTAURANT_MODE, Constant.RESTAURANT_MODE_DISTANCE);
        if (sortMode == Constant.RESTAURANT_MODE_DISTANCE) {
            latitude = getIntent().getDoubleExtra(Constant.LATITUDE, 0.0);
            longitude = getIntent().getDoubleExtra(Constant.LONGITUDE, 0.0);
            setTitle("Nearby Restaurant");
        }
        else {
            setTitle("Cheapest Restaurant");
        }
    }

    @NonNull
    @Override
    public RestaurantListPresenter providePresenter() {
        return new RestaurantListPresenter();
    }

    @Override
    public void updateDataset(List<Restaurant> restaurants) {
        adapter.updateDataset(restaurants);
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
