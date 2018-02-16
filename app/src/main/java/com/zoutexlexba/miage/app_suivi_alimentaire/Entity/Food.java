package com.zoutexlexba.miage.app_suivi_alimentaire.Entity;

import com.google.gson.annotations.SerializedName;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.NutrimentResponse;

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

    @SerializedName("nutriments")
    private NutrimentResponse nutriment;

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

    public NutrimentResponse getNutriment() {
        return nutriment;
    }

    public void setNutriment(NutrimentResponse nutriment) {
        this.nutriment = nutriment;
    }

    public String getNutrimentDescription() {
        String message = "Choisir la quantité consommée.\n";
        return message + "" +
                "Calories pour 100g : "
                + this.nutriment.getEnergy_100g()
                + "\n"
                + "Protéines pour 100g : "
                + this.nutriment.getProteins_100g()
                + "\n"
                + "Glucides pour 100g : "
                + this.nutriment.getCarbohydrates_100g()
                + "\n"
                + "Lipides pour 100g : "
                + this.nutriment.getFat_100g()
                + "\n"
                + "Fibres pour 100g : "
                + this.nutriment.getFiber_100g()
                + " "
        ;
    }
}
