package com.kwondeveloper.possemongo.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Mike on 9/3/2016.
 */
public class Programmers {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("favorite_color")
    @Expose
    private String favoriteColor;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("weight")
    @Expose
    private Double weight;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("is_artist")
    @Expose
    private Boolean isArtist;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getArtist() {
        return isArtist;
    }

    public void setArtist(Boolean artist) {
        isArtist = artist;
    }
}
