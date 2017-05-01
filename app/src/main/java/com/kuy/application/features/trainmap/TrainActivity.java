package com.kuy.application.features.trainmap;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.kuy.application.R;
import com.kuy.application.api.KuyService;
import com.kuy.application.features.BaseLocationActivity;
import com.kuy.application.features.BaseLocationPresenter;
import com.kuy.application.features.BaseLocationView;
import com.kuy.application.models.Hotel;
import com.kuy.application.models.RouteResult;
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

public class TrainActivity extends BaseLocationActivity<TrainPresenter, TrainView>
implements TrainView{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

    

    @NonNull
    @Override
    public TrainPresenter providePresenter() {
        return new TrainPresenter();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_train, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0)
            {
                TrainSummaryFragment fragment = new TrainSummaryFragment();
                Bundle args = new Bundle();
                args.putString(TrainSummaryFragment.ARG_MY_LATITUDE, "ARG_MY_LATITUDE");
                args.putString(TrainSummaryFragment.ARG_MY_LONGITUDE, "ARG_MY_LONGITUDE");
                args.putString(TrainSummaryFragment.ARG_START_STATION_NAME, "ARG_START_STATION_NAME");
                args.putString(TrainSummaryFragment.ARG_START_STATION_ADDRESS, "ARG_START_STATION_ADDRESS");
                args.putString(TrainSummaryFragment.ARG_DESTINATION_NAME, "ARG_DESTINATION_NAME");
                args.putString(TrainSummaryFragment.ARG_DESTINATION_ADDRESS, "ARG_DESTINATION_ADDRESS");
                args.putString(TrainSummaryFragment.ARG_GOAL_STATION_NAME, "ARG_GOAL_STATION_NAME");
                args.putString(TrainSummaryFragment.ARG_GOAL_STATION_ADDRESS, "ARG_GOAL_STATION_ADDRESS");
                args.putInt(TrainSummaryFragment.ARG_TOTAL_SCHEDULE, 5);

                fragment.setArguments(args);
                return fragment;
            }

            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
