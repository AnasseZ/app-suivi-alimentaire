package com.zoutexlexba.miage.app_suivi_alimentaire.Entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Paulalex on 31/01/2018.
 */

@DatabaseTable(tableName = "consomme")
public class Journee {

    @DatabaseField(id = true)
    private Date date_journee;
    @DatabaseField(canBeNull = false)
    private ArrayList<Integer> listAliment;
    @DatabaseField(canBeNull = false)
    private ArrayList<Integer> listRepas;

    public Journee(){}

    public Journee(Date jour){
        date_journee = jour;
        listAliment = new ArrayList<>();
        listRepas = new ArrayList<>();
    }

    public Date getDate_journee() {
        return date_journee;
    }

    public ArrayList<Integer> getListAliment() {
        return listAliment;
    }

    public void setListAliment(ArrayList<Integer> listAliment) {
        this.listAliment = listAliment;
    }

    public ArrayList<Integer> getListRepas() {
        return listRepas;
    }

    public void setListRepas(ArrayList<Integer> listRepas) {
        this.listRepas = listRepas;
    }
}
