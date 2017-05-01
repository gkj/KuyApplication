package com.kuy.application.features.restaurantlist;

import android.support.annotation.NonNull;

import com.kuy.application.api.KuyService;
import com.kuy.application.features.BasePresenter;
import com.kuy.application.models.Restaurant;
import com.kuy.application.util.Constant;
import com.kuy.application.util.RestaurantDistanceComparator;
import com.kuy.application.util.RestaurantPriceComparator;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gilang on 4/30/17.
 */

public class RestaurantListPresenter extends BasePresenter<RestaurantListView> {
    @Override
    protected void onAttachView(@NonNull RestaurantListView view) {
        super.onAttachView(view);

        getRestaurantList();
    }

    private void getRestaurantList() {

        getView().showProgressDialog();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(KuyService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        KuyService service = retrofit.create(KuyService.class);
        Call<List<Restaurant>> call = service.getRestaurantList();

        call.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
                if (response.isSuccessful()) {
                    List<Restaurant> restaurants = response.body();

                    // sort restaurant by price or distance
                    if (getView().getSortMode() == Constant.RESTAURANT_MODE_PRICE)
                        Collections.sort(restaurants, new RestaurantPriceComparator());
                    else
                        Collections.sort(restaurants, new RestaurantDistanceComparator((float) getView().getLatitude(), (float) getView().getLongitude()));

                    getView().updateDataset(restaurants);
                    getView().hideProgressDialog();
                }
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
                t.printStackTrace();
                getView().hideProgressDialog();
            }
        });
    }
}
