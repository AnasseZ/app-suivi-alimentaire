package com.zoutexlexba.miage.app_suivi_alimentaire.Entity;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.NutrimentResponse;

/**
 * Created by anassezougarh on 30/01/2018.
 */

@DatabaseTable(tableName = "food")
public class Food {

    @DatabaseField(generatedId = true)
    private Integer idFood;

    @DatabaseField
    @SerializedName("product_name_fr")
    private String name;

    @SerializedName("serving_size")
    private String quantity;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("product_name")
    public String realName;


    @DatabaseField
    private int energy_100g;

    @DatabaseField
    private double fiber_100g;

    @DatabaseField
    private double carbohydrates_100g;

    @DatabaseField
    private double proteins_100g;

    @DatabaseField
    private double fat_100g;

    @SerializedName("nutriments")
    private NutrimentResponse nutriment;

    public Food() {
    }

    public Food(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void initializeDataNutriment(double ratio){
        this.energy_100g = (int)(nutriment.getEnergy_100g() * ratio);
        this.fiber_100g = nutriment.getFiber_100g();
        this.carbohydrates_100g = nutriment.getCarbohydrates_100g();
        this.proteins_100g = nutriment.getProteins_100g();
        this.fat_100g = nutriment.getFat_100g();
    }

    public Integer getId() {
        return idFood;
    }

    public int getEnergy_100g() {
        return energy_100g;
    }

    public void setEnergy_100g(int energy_100g) {
        this.energy_100g = energy_100g;
    }

    public double getFiber_100g() {
        return fiber_100g;
    }

    public void setFiber_100g(double fiber_100g) {
        this.fiber_100g = fiber_100g;
    }

    public double getCarbohydrates_100g() {
        return carbohydrates_100g;
    }

    public void setCarbohydrates_100g(double carbohydrates_100g) {
        this.carbohydrates_100g = carbohydrates_100g;
    }

    public double getProteins_100g() {
        return proteins_100g;
    }

    public void setProteins_100g(double proteins_100g) {
        this.proteins_100g = proteins_100g;
    }

    public double getFat_100g() {
        return fat_100g;
    }

    public void setFat_100g(double fat_100g) {
        this.fat_100g = fat_100g;
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

    public String getNutrimentDescription(double ratio) {
        String message = "Choisir la quantité consommée.\n";
        return message + "" +
                "Calories pour 100g : "
                + (int)(this.nutriment.getEnergy_100g() * ratio)
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
