package com.kuy.application.features.trainmap;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.kuy.application.R;
import com.kuy.application.models.Plan;
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
    public static final String ARG_ROUTE_RESULT = "ARG_ROUTE_RESULT";

    private ScrollView scrollView;
    private TextView textview_my_latitude;
    private TextView textview_my_longitude;
    private TextView textview_nearest_start_station_name;
    private TextView textview_nearest_start_station_address;
    private TextView textview_destination_name;
    private TextView textview_destination_address;
    private TextView textview_nearest_goal_station_name;
    private TextView textview_nearest_goalstation_address;
    private TextView textview_total_schedule;
    private LinearLayout scheduleLayout;

    private LayoutInflater inflater;

    private RouteResult result;

    public TrainSummaryFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.inflater = inflater;
        View rootView = inflater.inflate(R.layout.fragment_train_summary, container, false);

        scrollView = (ScrollView) rootView.findViewById(R.id.scrollview);

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

        scheduleLayout = (LinearLayout) rootView.findViewById(R.id.layout_schedule);
        result = (RouteResult) getArguments().getParcelable(ARG_ROUTE_RESULT);
        if (result != null)
            showResult();

        return rootView;
    }

    public void updateResult(RouteResult result) {
        this.result = result;
        showResult();
    }

    public void updateCurrentLocation(Location location) {
        textview_my_latitude.setText("" + location.getLatitude());
        textview_my_longitude.setText("" + location.getLongitude());
    }

    public void updateDepartureStation(Station start) {
        textview_nearest_start_station_name.setText(start.getName());
        textview_nearest_start_station_address.setText(start.getAddress());
    }

    public void updateDestinationStation(Station goal) {
        textview_nearest_goal_station_name.setText(goal.getName());
        textview_nearest_goalstation_address.setText(goal.getAddress());
    }

    private void showResult() {
        textview_total_schedule.setText(result.getPlans().size() + " schedules available");

        scheduleLayout.removeAllViews();

        int counter = 0;
        for (Plan p : result.getPlans()) {
            View rv = inflater.inflate(R.layout.layout_schedule, scheduleLayout, false);
            bind(rv, counter);
            counter++;
            rv.invalidate();
            rv.requestLayout();
            scheduleLayout.addView(rv);
            scheduleLayout.invalidate();
            scheduleLayout.requestLayout();
        }

        scheduleLayout.setVisibility(View.GONE);
        scheduleLayout.setVisibility(View.VISIBLE);

        scrollView.invalidate();
        scrollView.requestLayout();

    }

    private void bind(View rootView, int counter) {
        TextView plan = (TextView) rootView.findViewById(R.id.textview_plan);
        plan.setText(String.format("Plan %s", (counter+1)));

        TextView departure = (TextView) rootView.findViewById(R.id.textview_departure);
        String[] from = result.getPlans().get(counter).getSummary().getMove().getFromTime().split("T");
        departure.setText(from[1].substring(0, 5));

        TextView departureStation = (TextView) rootView.findViewById(R.id.textview_departure_station);
        departureStation.setText(result.getPlans().get(counter).getSummary().getStartName());

        TextView arrival = (TextView) rootView.findViewById(R.id.textview_arrival);
        String[] to = result.getPlans().get(counter).getSummary().getMove().getToTime().split("T");
        arrival.setText(to[1].substring(0,5));

        TextView arrivalStation = (TextView) rootView.findViewById(R.id.textview_arrival_station);
        arrivalStation.setText(result.getPlans().get(counter).getSummary().getGoalName());

        TextView duration = (TextView) rootView.findViewById(R.id.textview_duration);
        duration.setText("" + result.getPlans().get(counter).getSummary().getMove().getTime() + " min");

        TextView transit = (TextView) rootView.findViewById(R.id.textview_transit_count);
        transit.setText("" + result.getPlans().get(counter).getSummary().getMove().getTransitCount());
    }
}
