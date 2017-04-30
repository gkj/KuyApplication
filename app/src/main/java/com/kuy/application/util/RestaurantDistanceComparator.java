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

    private float distance (float lat_a, float lng_a, float lat_b, float lng_b )
    {
        double earthRadius = 3958.75;
        double latDiff = Math.toRadians(lat_b-lat_a);
        double lngDiff = Math.toRadians(lng_b-lng_a);
        double a = Math.sin(latDiff /2) * Math.sin(latDiff /2) +
                Math.cos(Math.toRadians(lat_a)) * Math.cos(Math.toRadians(lat_b)) *
                        Math.sin(lngDiff /2) * Math.sin(lngDiff /2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double distance = earthRadius * c;

        int meterConversion = 1609;

        return new Float(distance * meterConversion).floatValue();
    }

    @Override
    public int compare(Restaurant o1, Restaurant o2) {
        float res1Lat = Float.parseFloat(o1.getLatitude());
        float res1Long = Float.parseFloat(o1.getLongitude());

        float res2Lat = Float.parseFloat(o2.getLatitude());
        float res2Long = Float.parseFloat(o2.getLongitude());

        float result = distance(lat, lng, res1Lat, res1Long) - distance(lat, lng, res2Lat, res2Long);

        if (Float.compare(result, 0.0f) == 0)
            return 0;
        else
            return result < 0.0f ? -1 : 1;
    }
}
