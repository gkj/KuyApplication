package com.kuy.application.util;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;
import com.kuy.application.models.Hotel;

import java.util.Comparator;

/**
 * Created by gilang on 4/29/17.
 */

public class HotelDistanceComparator implements Comparator<Hotel> {

    private float lat;
    private float lng;

    public HotelDistanceComparator(float lat, float lng) {
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
    public int compare(Hotel o1, Hotel o2) {

        float hotel1Lat = Float.parseFloat(o1.getLatitude());
        float hotel1Long = Float.parseFloat(o1.getLongitude());

        float hotel2Lat = Float.parseFloat(o2.getLatitude());
        float hotel2Long = Float.parseFloat(o2.getLongitude());

        float result = distance(lat, lng, hotel1Lat, hotel1Long) - distance(lat, lng, hotel2Lat, hotel2Long);

        if (Float.compare(result, 0.0f) == 0)
            return 0;
        else
            return result < 0.0f ? -1 : 1;
    }
}
