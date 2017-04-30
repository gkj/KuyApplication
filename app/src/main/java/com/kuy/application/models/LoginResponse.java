package com.kuy.application.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gilang on 4/27/17.
 */

public class LoginResponse {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("error_msg")
    @Expose
    private String errorMessage;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("user")
    @Expose
    private User user;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
