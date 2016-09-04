package com.kwondeveloper.possemongo.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Mike on 9/3/2016.
 */
public class JsonObject {

    @SerializedName("status")
    @Expose
    private Integer status;

    @SerializedName("response")
    @Expose
    private Response response;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
