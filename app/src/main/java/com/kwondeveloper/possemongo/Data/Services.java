package com.kwondeveloper.possemongo.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 9/3/2016.
 */
public class Services {
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("programmers")
    @Expose
    private List<Programmers> programmers = new ArrayList<Programmers>();

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public List<Programmers> getProgrammers() {
        return programmers;
    }

    public void setProgrammers(List<Programmers> programmers) {
        this.programmers = programmers;
    }
}
