package com.kuy.application.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gilang on 5/1/17.
 */

public class Move {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("transit_count")
    @Expose
    private Integer transitCount;
    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("from_time")
    @Expose
    private String fromTime;
    @SerializedName("to_time")
    @Expose
    private String toTime;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTransitCount() {
        return transitCount;
    }

    public void setTransitCount(Integer transitCount) {
        this.transitCount = transitCount;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

}
