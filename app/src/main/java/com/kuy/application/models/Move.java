package com.kuy.application.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gilang on 5/1/17.
 */

public class Move implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeInt(transitCount);
        dest.writeInt(time);
        dest.writeString(fromTime);
        dest.writeString(toTime);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Move> CREATOR = new Parcelable.Creator<Move>() {
        public Move createFromParcel(Parcel in) {
            return new Move(in);
        }

        public Move[] newArray(int size) {
            return new Move[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private Move(Parcel in) {
        type = in.readString();
        transitCount = in.readInt();
        time = in.readInt();
        fromTime = in.readString();
        toTime = in.readString();
    }
}
