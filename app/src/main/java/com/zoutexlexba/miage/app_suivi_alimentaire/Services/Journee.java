package com.zoutexlexba.miage.app_suivi_alimentaire.Services;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Paulalex on 31/01/2018.
 */

@DatabaseTable(tableName = "journee")
public class Journee {

    @DatabaseField(id = true)
    private Date date_journee;
    @DatabaseField(canBeNull = false)
    private ArrayList<Aliment> list_aliment;
    @DatabaseField(canBeNull = false)
    private ArrayList<Repas> list_repas;

    public Journee(){}

    public Journee(Date jour){
        date_journee = jour;
        list_aliment = new ArrayList<>();
        list_repas = new ArrayList<>();
    }

    public Date getDate_journee() {
        return date_journee;
    }

    public void setDate_journee(Date date_journee) {
        this.date_journee = date_journee;
    }

    public ArrayList<Aliment> getList_aliment() {
        return list_aliment;
    }

    public ArrayList<Repas> getList_repas() {
        return list_repas;
    }

    public void AjoutAliment(Aliment aliment){
        list_aliment.add(aliment);
    }

    public void AjoutRepas(Repas repas){
        list_repas.add(repas);
    }
}
