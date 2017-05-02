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

    @Override
    public int compare(Hotel o1, Hotel o2) {

        float hotel1Lat = Float.parseFloat(o1.getLatitude());
        float hotel1Long = Float.parseFloat(o1.getLongitude());

        float hotel2Lat = Float.parseFloat(o2.getLatitude());
        float hotel2Long = Float.parseFloat(o2.getLongitude());

        double result = CoordinateUtil.distance(lat, lng, hotel1Lat, hotel1Long, 0.0, 0.0) - CoordinateUtil.distance(lat, lng, hotel2Lat, hotel2Long, 0.0, 0.0);

        if (Double.compare(result, 0.0) == 0)
            return 0;
        else
            return result < 0.0 ? -1 : 1;
    }
}
