package com.zoutexlexba.miage.app_suivi_alimentaire.Entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;

/**
 * Created by Paulalex on 31/01/2018.
 */

@DatabaseTable(tableName = "meal")
public class Meal {

    @DatabaseField(generatedId  = true)
    private int id;
    @DatabaseField
    private String nom;

    public Meal(){}

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
