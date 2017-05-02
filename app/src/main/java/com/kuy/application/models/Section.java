package com.kuy.application.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gilang on 5/1/17.
 */
public class Section implements Parcelable {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("node_id")
    @Expose
    private String nodeId;
    @SerializedName("node_name")
    @Expose
    private String nodeName;
    @SerializedName("move")
    @Expose
    private String move;
    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("from_time")
    @Expose
    private String fromTime;
    @SerializedName("to_time")
    @Expose
    private String toTime;
    @SerializedName("operation_id")
    @Expose
    private String operationId;
    @SerializedName("operation_name")
    @Expose
    private String operationName;
    @SerializedName("link_id")
    @Expose
    private String linkId;
    @SerializedName("link_name")
    @Expose
    private String linkName;
    @SerializedName("company_id")
    @Expose
    private String companyId;
    @SerializedName("destination_node_id")
    @Expose
    private String destinationNodeId;
    @SerializedName("destination_node_name")
    @Expose
    private String destinationNodeName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
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

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getDestinationNodeId() {
        return destinationNodeId;
    }

    public void setDestinationNodeId(String destinationNodeId) {
        this.destinationNodeId = destinationNodeId;
    }

    public String getDestinationNodeName() {
        return destinationNodeName;
    }

    public void setDestinationNodeName(String destinationNodeName) {
        this.destinationNodeName = destinationNodeName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(nodeId);
        dest.writeString(nodeName);
        dest.writeString(move);
        dest.writeInt(time);
        dest.writeString(fromTime);
        dest.writeString(toTime);
        dest.writeString(operationId);
        dest.writeString(operationName);
        dest.writeString(linkId);
        dest.writeString(linkName);
        dest.writeString(companyId);
        dest.writeString(destinationNodeId);
        dest.writeString(destinationNodeName);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Section> CREATOR = new Parcelable.Creator<Section>() {
        public Section createFromParcel(Parcel in) {
            return new Section(in);
        }

        public Section[] newArray(int size) {
            return new Section[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private Section(Parcel in) {
        type = in.readString();
        nodeId = in.readString();
        nodeName = in.readString();
        move = in.readString();
        time = in.readInt();
        fromTime = in.readString();
        toTime = in.readString();
        operationId = in.readString();
        operationName = in.readString();
        linkId = in.readString();
        linkName = in.readString();
        companyId = in.readString();
        destinationNodeId = in.readString();
        destinationNodeName = in.readString();
    }
}
