package com.zoutexlexba.miage.app_suivi_alimentaire.Entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by anassezougarh on 30/01/2018.
 */

public class Food {
    @SerializedName("product_name_fr")
    public String name;

    @SerializedName("serving_size")
    public String quantity;

    @SerializedName("image_url")
    public String imageUrl;

    @SerializedName("product_name")
    public String realName;

    public Food() {

    }

    public Food(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
