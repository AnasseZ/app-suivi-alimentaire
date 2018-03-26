package com.zoutexlexba.miage.app_suivi_alimentaire.Entity;

import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Test on 14/03/2018.
 */

@DatabaseTable(tableName = "User")
public class User {

    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField(canBeNull = false)
    private String name;
    //@DatabaseField(columnName = "email")
    //private String email;
    @DatabaseField(canBeNull = false)
    private String password;
    @DatabaseField
    private Double weight ;
    @DatabaseField
    private String obj;
    @DatabaseField
    private Integer age;


    public Double getWeight() { return weight; }

    public void setWeight(Double weight) { this.weight = weight; }

    public String getObj() { return obj; }

    public void setObj(String obj) { this.obj = obj; }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    public Integer getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    /*public String getEmail(){
        return this.email;
    }*/

    public String getPassword(){
        return this.password;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    /*public void setEmail(String email){
        this.email=email;
    }*/

    public void setPassword(String password){
        this.password=password;
    }

    public User()
    {

    }

    public User(String name, String email, String password){
        this.name=name;
        //this.email=email;
        this.password=password;
    }

    public User(String login, String password){
        this.name=login;
        this.password=password;

    }

    public User(String login, String password, Double weight , String obj, Integer age){
        this.name = name;
        this.password = password;
        this.age = age;
        this.weight = weight;
        this.obj = obj;
        //this.email = null;
    }

}
