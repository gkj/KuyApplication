package com.kuy.application.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gilang on 5/1/17.
 */
public class Summary implements Parcelable {

    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("start_name")
    @Expose
    private String startName;
    @SerializedName("goal")
    @Expose
    private String goal;
    @SerializedName("goal_name")
    @Expose
    private String goalName;
    @SerializedName("move")
    @Expose
    private Move move;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStartName() {
        return startName;
    }

    public void setStartName(String startName) {
        this.startName = startName;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(start);
        dest.writeString(startName);
        dest.writeString(goal);
        dest.writeString(goalName);
        dest.writeParcelable(move, flags);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Summary> CREATOR = new Parcelable.Creator<Summary>() {
        public Summary createFromParcel(Parcel in) {
            return new Summary(in);
        }

        public Summary[] newArray(int size) {
            return new Summary[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private Summary(Parcel in) {
        start = in.readString();
        startName = in.readString();
        goal = in.readString();
        goalName = in.readString();
        move = in.readParcelable(Move.class.getClassLoader());
    }
}