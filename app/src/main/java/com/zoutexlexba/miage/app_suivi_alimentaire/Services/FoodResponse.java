package com.zoutexlexba.miage.app_suivi_alimentaire.Services;

import com.google.gson.annotations.SerializedName;

/**
 * Created by anassezougarh on 16/01/2018.
 */

public class FoodResponse {
    @SerializedName("nom")
    public String nom;
    @SerializedName("grammes")
    public int grammes;

}
