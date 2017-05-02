package com.kuy.application.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gilang on 5/1/17.
 */

public class RouteResult implements Parcelable {
    @SerializedName("items")
    @Expose
    private List<Plan> plans = null;

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(plans);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<RouteResult> CREATOR = new Parcelable.Creator<RouteResult>() {
        public RouteResult createFromParcel(Parcel in) {
            return new RouteResult(in);
        }

        public RouteResult[] newArray(int size) {
            return new RouteResult[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private RouteResult(Parcel in) {
        in.readList(plans, List.class.getClassLoader());
    }
}
