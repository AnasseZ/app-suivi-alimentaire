package com.zoutexlexba.miage.app_suivi_alimentaire.Services;

import com.google.gson.annotations.SerializedName;

/**
 * Created by anassezougarh on 15/02/2018.
 */

public class NutrimentResponse {

    @SerializedName("energy_100g")
    private int energy_100g;

    @SerializedName("fiber_100g")
    private double fiber_100g;

    @SerializedName("carbohydrates_100g")
    private double carbohydrates_100g;

    @SerializedName("proteins_100g")
    private double proteins_100g;

    @SerializedName("fat_100g")
    private double fat_100g;

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
}
