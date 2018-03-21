package com.zoutexlexba.miage.app_suivi_alimentaire.Entity;

import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Test on 14/03/2018.
 */

@DatabaseTable(tableName = "user")
public class User {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "name", canBeNull = false)
    private String name;
    @DatabaseField(columnName = "email", canBeNull = false)
    private String email;
    @DatabaseField(columnName = "password", canBeNull = false)
    private String password;
    @DatabaseField(columnName = "weight")
    private Float weight ;
    @DatabaseField(columnName = "objective")
    private int obj;
    @DatabaseField(columnName = "age")
    private int age;


    public Float getWeight() { return weight; }

    public void setWeight(Float weight) { this.weight = weight; }

    public int getObj() { return obj; }

    public void setObj(int obj) { this.obj = obj; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public void setId(int id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public User(){
        this.name=null;
        this.email=null;
        this.password=null;
    }

    public User(String name, String email, String password){
        this.name=name;
        this.email=email;
        this.password=password;
    }

    public User(String login, String password){
        this.name=login;
        this.password=password;

    }

}
