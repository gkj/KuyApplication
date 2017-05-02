package com.kuy.application.features.trainmap;

import android.location.Location;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.kuy.application.api.KuyService;
import com.kuy.application.features.BaseLocationPresenter;
import com.kuy.application.models.RouteResult;
import com.kuy.application.models.Station;
import com.kuy.application.util.Constant;
import com.kuy.application.util.StationUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gilang on 5/2/17.
 */

public class TrainPresenter extends BaseLocationPresenter<TrainView> {

    @Override
    protected void onWakeUp() {
        super.onWakeUp();

        showProgressDialog("Getting train schedules...");
        requestCurrentLocation();
    }

    private Station getNearestStation(double lat, double lng) {
        //search nearest station from my location
        double smallest = Double.MAX_VALUE;
        Station nearest = null;
        StationUtil.getInstance().loadStationsFromData(getActivity());
        for(Station s : StationUtil.getInstance().getStations()) {
            double d = distance(lat, Double.parseDouble(s.getLatitude()), lng, Double.parseDouble(s.getLongitude()), 0.0, 0.0);
            if (d < smallest) {
                smallest = d;
                nearest = s;
            }
        }
        return nearest;
    }

    private void getRoute(Station start, Station goal){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(KuyService.ROUTE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        KuyService service = retrofit.create(KuyService.class);

        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");

        String timeStamp = String.format("%sT%s", sdf.format(now), sdf2.format(now));

        String timezone = TimeZone.getDefault().getID();

        Call<RouteResult> call = service.getRoutes(start.getId(), goal.getId(), timeStamp, "MY", "UTC+08:00");

        call.enqueue(new Callback<RouteResult>() {
            @Override
            public void onResponse(Call<RouteResult> call, Response<RouteResult> response) {

                hideProgressDialog();

                if (response.isSuccessful()) {
                    getView().updateResult(response.body());
                }
                else {
                    showMessage(response.message());
                }

            }

            @Override
            public void onFailure(Call<RouteResult> call, Throwable t) {
                hideProgressDialog();
            }
        });
    }

    public double distance(double lat1, double lat2, double lon1,
                           double lon2, double el1, double el2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    @Override
    public void onLocationReceived(Location location) {
        getView().updateCurrentLocation(location);

        Station start = getNearestStation(location.getLatitude(), location.getLongitude());
        getView().updateDepartureStation(start);

        Station goal = getNearestStation(getView().getDestinationLatitude(), getView().getDestinationLongitude());
        getView().updateDestinationStation(goal);

        getRoute(start, goal);
    }
}
