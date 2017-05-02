package com.kuy.application.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gilang on 5/1/17.
 */

public class Plan implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(summary, flags);
        dest.writeList(sections);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Plan> CREATOR = new Parcelable.Creator<Plan>() {
        public Plan createFromParcel(Parcel in) {
            return new Plan(in);
        }

        public Plan[] newArray(int size) {
            return new Plan[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private Plan(Parcel in) {
        summary = in.readParcelable(Summary.class.getClassLoader());
        in.readList(sections, List.class.getClassLoader());
    }
}
