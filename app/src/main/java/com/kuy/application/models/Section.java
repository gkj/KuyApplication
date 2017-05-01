package com.kuy.application.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gilang on 5/1/17.
 */
public class Section {

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

}
