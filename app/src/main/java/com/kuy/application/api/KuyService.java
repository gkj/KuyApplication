package com.kuy.application.api;

import com.kuy.application.models.Hotel;
import com.kuy.application.models.Restaurant;
import com.kuy.application.models.RouteResult;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by gilang on 4/26/17.
 */

public interface KuyService {
    String BASE_URL = "http://kuywisata.hol.es";
    String ROUTE_URL = "http://api.aws.navitime.com";

    @Multipart
    @POST("login.php")
    Call<String> login(@Part("email") RequestBody email, @Part("password") RequestBody password);

    @Multipart
    @POST("register.php")
    Call<String> register(@Part("name") RequestBody name, @Part("email") RequestBody email, @Part("password") RequestBody password);

    @GET("list_hotel.php")
    Call<List<Hotel>> getHotelList();

    @GET("list_restoran.php")
    Call<List<Restaurant>> getRestaurantList();

    @GET("thomas/route")
    Call<RouteResult> getRoutes(
            @Query("start") String start,
            @Query("goal") String goal,
            @Query("start-time") String startTime,
            @Query("country") String country,
            @Query(value = "timezone", encoded = false) String timezone);
}
