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

    public Food() {

    }

    public Food(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
