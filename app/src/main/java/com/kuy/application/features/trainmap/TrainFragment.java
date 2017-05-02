package com.kuy.application.features.trainmap;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kuy.application.R;
import com.kuy.application.features.hoteldetail.HotelDetailActivity;
import com.kuy.application.features.hotellist.HotelListAdapter;
import com.kuy.application.models.Hotel;
import com.kuy.application.models.Plan;
import com.kuy.application.models.Section;
import com.kuy.application.util.Constant;

import java.util.ArrayList;

/**
 * Created by gilang on 5/2/17.
 */

public class TrainFragment extends Fragment {

    public static final String ARG_PLAN = "ARG_PLAN";

    private RecyclerView recyclerView;
    private TrainStepAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_train, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_train);
        recyclerView.setHasFixedSize(true);

        Plan plan = getArguments() != null ? (Plan) getArguments().getParcelable(ARG_PLAN) : null;

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter

        adapter = new TrainStepAdapter(getActivity(), plan, new TrainStepAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Section item) {

            }
        });


        recyclerView.setAdapter(adapter);

        return rootView;
    }


}
