package com.zoutexlexba.miage.app_suivi_alimentaire.Entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Paulalex on 31/01/2018.
 */

@DatabaseTable(tableName = "aliment")
public class Aliment {

    @DatabaseField(id = true)
    private String nom;
    @DatabaseField(canBeNull = false)
    private float quantite;
    @DatabaseField
    private float calories;
    @DatabaseField
    private float glucides;

    public Aliment(){ }

    public Aliment(String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getQuantite() {
        return quantite;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public float getGlucides() {
        return glucides;
    }

    public void setGlucides(float glucides) {
        this.glucides = glucides;
    }


}
