package com.kuy.application.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gilang on 5/1/17.
 */
public class Summary {

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

}