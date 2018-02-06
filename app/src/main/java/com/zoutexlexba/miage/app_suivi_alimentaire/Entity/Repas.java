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
    @DatabaseField(canBeNull = false)
    private ArrayList<Aliment> list_aliment;

    public Repas(){}

    public void AjoutAliment(Aliment aliment){
        list_aliment.add(aliment);
    }

}
