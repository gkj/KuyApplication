package com.kuy.application.util;

import com.kuy.application.models.Restaurant;

import java.util.Comparator;

/**
 * Created by gilang on 4/30/17.
 */

public class RestaurantDistanceComparator implements Comparator<Restaurant> {

    private float lat;
    private float lng;

    public RestaurantDistanceComparator(float lat, float lng) {
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public int compare(Restaurant o1, Restaurant o2) {
        float res1Lat = Float.parseFloat(o1.getLatitude());
        float res1Long = Float.parseFloat(o1.getLongitude());

        float res2Lat = Float.parseFloat(o2.getLatitude());
        float res2Long = Float.parseFloat(o2.getLongitude());

        double result = CoordinateUtil.distance(lat, lng, res1Lat, res1Long, 0.0, 0.0) - CoordinateUtil.distance(lat, lng, res2Lat, res2Long, 0.0, 0.0);

        if (Double.compare(result, 0.0) == 0)
            return 0;
        else
            return result < 0.0 ? -1 : 1;
    }
}
