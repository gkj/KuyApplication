package com.kuy.application.api;

import com.kuy.application.models.Hotel;
import com.kuy.application.models.Restaurant;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

/**
 * Created by gilang on 4/26/17.
 */

public interface KuyService {
    String BASE_URL = "";

    @Multipart
    @POST("login.php")
    Call<String> login(@Part("email") RequestBody email, @Part("password") RequestBody password);

    @GET("list_hotel.php")
    Call<List<Hotel>> getHotelList();

    @GET("list_restoran.php")
    Call<List<Restaurant>> getRestaurantList();
}
