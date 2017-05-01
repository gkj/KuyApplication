package com.kuy.application.features.trainmap;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kuy.application.R;

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

    public TrainSummaryFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_train_summary, container, false);

        TextView textView = (TextView) rootView.findViewById(R.id.textview_my_latitude);
        textView.setText(getArguments().getString(ARG_MY_LATITUDE));

        textView = (TextView) rootView.findViewById(R.id.textview_my_longitude);
        textView.setText(getArguments().getString(ARG_MY_LONGITUDE));

        textView = (TextView) rootView.findViewById(R.id.textview_nearest_start_station_name);
        textView.setText(getArguments().getString(ARG_START_STATION_NAME));

        textView = (TextView) rootView.findViewById(R.id.textview_nearest_start_station_address);
        textView.setText(getArguments().getString(ARG_START_STATION_ADDRESS));

        textView = (TextView) rootView.findViewById(R.id.textview_destination_name);
        textView.setText(getArguments().getString(ARG_DESTINATION_NAME));

        textView = (TextView) rootView.findViewById(R.id.textview_destination_address);
        textView.setText(getArguments().getString(ARG_DESTINATION_ADDRESS));

        textView = (TextView) rootView.findViewById(R.id.textview_nearest_goal_station_name);
        textView.setText(getArguments().getString(ARG_GOAL_STATION_NAME));

        textView = (TextView) rootView.findViewById(R.id.textview_nearest_goalstation_address);
        textView.setText(getArguments().getString(ARG_GOAL_STATION_ADDRESS));

        textView = (TextView) rootView.findViewById(R.id.textview_total_schedule);
        textView.setText(getArguments().getInt(ARG_TOTAL_SCHEDULE) + " schedules available");

        return rootView;
    }
}
