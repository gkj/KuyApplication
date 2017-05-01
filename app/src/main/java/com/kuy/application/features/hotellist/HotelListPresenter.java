package com.kuy.application.features.hotellist;

import android.support.annotation.NonNull;

import com.kuy.application.api.KuyService;
import com.kuy.application.features.BasePresenter;
import com.kuy.application.models.Hotel;
import com.kuy.application.util.Constant;
import com.kuy.application.util.HotelDistanceComparator;
import com.kuy.application.util.HotelPriceComparator;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gilang on 4/29/17.
 */

public class HotelListPresenter extends BasePresenter<HotelListView> {
    @Override
    protected void onAttachView(@NonNull HotelListView view) {
        super.onAttachView(view);

        getHotelList();
    }

    private void getHotelList() {

        getView().showProgressDialog();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(KuyService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        KuyService service = retrofit.create(KuyService.class);
        Call<List<Hotel>> call = service.getHotelList();

        call.enqueue(new Callback<List<Hotel>>() {
            @Override
            public void onResponse(Call<List<Hotel>> call, Response<List<Hotel>> response) {
                if (response.isSuccessful()) {
                    List<Hotel> hotels = response.body();

                    // sort hotel by price or distance
                    if (getView().getSortMode() == Constant.HOTEL_MODE_PRICE)
                        Collections.sort(hotels, new HotelPriceComparator());
                    else
                        Collections.sort(hotels, new HotelDistanceComparator((float) getView().getLatitude(), (float) getView().getLongitude()));

                    getView().updateDataset(hotels);
                    getView().hideProgressDialog();
                }
            }

            @Override
            public void onFailure(Call<List<Hotel>> call, Throwable t) {
                t.printStackTrace();
                getView().hideProgressDialog();
            }
        });
    }
}
