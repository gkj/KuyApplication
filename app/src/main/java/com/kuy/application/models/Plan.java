package com.kuy.application.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gilang on 5/1/17.
 */

public class Plan {
    @SerializedName("summary")
    @Expose
    private Summary summary;
    @SerializedName("sections")
    @Expose
    private List<Section> sections = null;

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
