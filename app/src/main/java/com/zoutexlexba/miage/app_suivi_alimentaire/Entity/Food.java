package com.zoutexlexba.miage.app_suivi_alimentaire.Entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by anassezougarh on 30/01/2018.
 */

public class Food {
    @SerializedName("product_name_fr")
    private String name;

    @SerializedName("serving_size")
    private String quantity;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("product_name")
    public String realName;

    private int quantityConsumed;

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

    public int getQuantityConsumed() {
        return quantityConsumed;
    }

    public void setQuantityConsumed(int quantityConsumed) {
        this.quantityConsumed = quantityConsumed;
    }

    public String getUsableName() {
        if (name == null) {
            return realName;
        }

        return name;
    }
}
