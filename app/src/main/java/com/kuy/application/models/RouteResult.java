package com.kuy.application.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gilang on 5/1/17.
 */

public class RouteResult {
    @SerializedName("items")
    @Expose
    private List<Plan> plans = null;

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }
}
