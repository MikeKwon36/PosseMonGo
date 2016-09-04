package com.kwondeveloper.possemongo.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 9/3/2016.
 */
public class Response {

    @SerializedName("locations")
    @Expose
    private List<Locations> locations = new ArrayList<Locations>();

    public List<Locations> getLocations() {
        return locations;
    }

    public void setLocations(List<Locations> locations) {
        this.locations = locations;
    }
}
