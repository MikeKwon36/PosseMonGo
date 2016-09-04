package com.kwondeveloper.possemongo.Data;

/**
 * Created by Mike on 9/3/2016.
 */
public class Posse {
    public String name;
    public String favoriteColor;
    public Integer age;
    public Double weight;
    public String phone;
    public Boolean isArtist;
    public String locality;
    public String region;
    public String postalCode;
    public String country;
    public String platform;

    public Posse() {}

    public Posse(Posse template) {
        if(template.name != null) this.name = template.name;
        if(template.favoriteColor != null) this.favoriteColor = template.favoriteColor;
        if(template.age != null) this.age = template.age;
        if(template.weight != null) this.weight = template.weight;
        if(template.phone != null) this.phone = template.phone;
        if(template.isArtist != null) this.isArtist = template.isArtist;
        if(template.locality != null) this.locality = template.locality;
        if(template.region != null) this.region = template.region;
        if(template.postalCode != null) this.postalCode = template.postalCode;
        if(template.country != null) this.country = template.country;
        if(template.platform != null) this.platform = template.platform;
    }

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

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
