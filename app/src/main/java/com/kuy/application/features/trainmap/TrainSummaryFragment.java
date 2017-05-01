package com.kuy.application.features.trainmap;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kuy.application.R;
import com.kuy.application.models.RouteResult;
import com.kuy.application.models.Station;

/**
 * Created by gilang on 5/2/17.
 */

public class TrainSummaryFragment extends Fragment {

    public static final String ARG_MY_LATITUDE = "ARG_MY_LATITUDE";
    public static final String ARG_MY_LONGITUDE = "ARG_MY_LONGITUDE";
    public static final String ARG_START_STATION_NAME = "ARG_START_STATION_NAME";
    public static final String ARG_START_STATION_ADDRESS = "ARG_START_STATION_ADDRESS";
    public static final String ARG_DESTINATION_NAME = "ARG_DESTINATION_NAME";
    public static final String ARG_DESTINATION_ADDRESS = "ARG_DESTINATION_ADDRESS";
    public static final String ARG_GOAL_STATION_NAME = "ARG_GOAL_STATION_NAME";
    public static final String ARG_GOAL_STATION_ADDRESS = "ARG_GOAL_STATION_ADDRESS";
    public static final String ARG_TOTAL_SCHEDULE = "ARG_TOTAL_SCHEDULE";

    private TextView textview_my_latitude;
    private TextView textview_my_longitude;
    private TextView textview_nearest_start_station_name;
    private TextView textview_nearest_start_station_address;
    private TextView textview_destination_name;
    private TextView textview_destination_address;
    private TextView textview_nearest_goal_station_name;
    private TextView textview_nearest_goalstation_address;
    private TextView textview_total_schedule;

    private RouteResult result;

    public TrainSummaryFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_train_summary, container, false);

        textview_my_latitude = (TextView) rootView.findViewById(R.id.textview_my_latitude);
        textview_my_latitude.setText(getArguments().getString(ARG_MY_LATITUDE));

        textview_my_longitude = (TextView) rootView.findViewById(R.id.textview_my_longitude);
        textview_my_longitude.setText(getArguments().getString(ARG_MY_LONGITUDE));

        textview_nearest_start_station_name = (TextView) rootView.findViewById(R.id.textview_nearest_start_station_name);
        textview_nearest_start_station_name.setText(getArguments().getString(ARG_START_STATION_NAME));

        textview_nearest_start_station_address = (TextView) rootView.findViewById(R.id.textview_nearest_start_station_address);
        textview_nearest_start_station_address.setText(getArguments().getString(ARG_START_STATION_ADDRESS));

        textview_destination_name = (TextView) rootView.findViewById(R.id.textview_destination_name);
        textview_destination_name.setText(getArguments().getString(ARG_DESTINATION_NAME));

        textview_destination_address = (TextView) rootView.findViewById(R.id.textview_destination_address);
        textview_destination_address.setText(getArguments().getString(ARG_DESTINATION_ADDRESS));

        textview_nearest_goal_station_name = (TextView) rootView.findViewById(R.id.textview_nearest_goal_station_name);
        textview_nearest_goal_station_name.setText(getArguments().getString(ARG_GOAL_STATION_NAME));

        textview_nearest_goalstation_address = (TextView) rootView.findViewById(R.id.textview_nearest_goalstation_address);
        textview_nearest_goalstation_address.setText(getArguments().getString(ARG_GOAL_STATION_ADDRESS));

        textview_total_schedule = (TextView) rootView.findViewById(R.id.textview_total_schedule);
        textview_total_schedule.setText(getArguments().getInt(ARG_TOTAL_SCHEDULE) + " schedules available");

        return rootView;
    }

    public void updateResult(RouteResult result) {
        this.result = result;
        textview_total_schedule.setText(result.getPlans().size() + " schedules available");
    }

    public void updateCurrentLocation(Location location) {
        textview_my_latitude.setText("" + location.getLatitude());
        textview_my_longitude.setText("" + location.getLongitude());
    }

    public void updateDepartureStation(Station start){
        textview_nearest_start_station_name.setText(start.getName());
        textview_nearest_start_station_address.setText(start.getAddress());
    }

    public void updateDestinationStation(Station goal){
        textview_nearest_goal_station_name.setText(goal.getName());
        textview_nearest_goalstation_address.setText(goal.getAddress());
    }
}
