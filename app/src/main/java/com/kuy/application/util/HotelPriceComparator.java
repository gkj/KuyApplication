package com.kuy.application.util;

import com.kuy.application.models.Hotel;

import java.util.Comparator;

/**
 * Created by gilang on 4/29/17.
 */

public class HotelPriceComparator implements Comparator<Hotel> {

    @Override
    public int compare(Hotel o1, Hotel o2) {
        return Integer.parseInt(o1.getPrice()) - Integer.parseInt(o2.getPrice());
    }
}
