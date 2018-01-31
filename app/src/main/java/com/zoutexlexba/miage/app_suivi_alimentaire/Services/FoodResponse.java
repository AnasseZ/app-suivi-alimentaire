package com.zoutexlexba.miage.app_suivi_alimentaire.Services;

import com.google.gson.annotations.SerializedName;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Food;

import java.util.ArrayList;

/**
 * Created by anassezougarh on 16/01/2018.
 */

public class FoodResponse {
    @SerializedName("products")
    public ArrayList<Food> foodList;

    public FoodResponse() {
        this.foodList = new ArrayList<>();
    }
}
