package com.kuy.application.util;

import com.kuy.application.models.Restaurant;

import java.util.Comparator;

/**
 * Created by gilang on 4/30/17.
 */

public class RestaurantPriceComparator implements Comparator<Restaurant> {
    @Override
    public int compare(Restaurant o1, Restaurant o2) {
        return Integer.parseInt(o1.getAverageCost()) - Integer.parseInt(o2.getAverageCost());
    }
}
