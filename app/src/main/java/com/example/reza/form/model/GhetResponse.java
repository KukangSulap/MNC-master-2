package com.example.reza.form.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GhetResponse {
    @SerializedName("success")
    String success;

    @SerializedName("message")
    String message;

    @SerializedName("results")
    private List<ResponseDb> results;

    public String getSuccess() {
        return success;
    }
    public void setSuccess(String success) {
        this.success = success;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResponseDb> getResults(){
        return results;
    }

    public void setResults(List<ResponseDb> results) {
        this.results = results;

    }
}