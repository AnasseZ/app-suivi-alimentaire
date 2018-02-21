package com.zoutexlexba.miage.app_suivi_alimentaire.Entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;

/**
 * Created by Paulalex on 31/01/2018.
 */

@DatabaseTable(tableName = "repas")
public class Repas {

    @DatabaseField(generatedId  = true)
    private int id;
    @DatabaseField
    private String nom;
    @DatabaseField(canBeNull = false)
    private ArrayList<Integer> listConsomme;

    public Repas(){}

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Integer> getListConsomme() {
        return listConsomme;
    }

    public void setListConsomme(ArrayList<Integer> listConsomme) {
        this.listConsomme = listConsomme;
    }
}
