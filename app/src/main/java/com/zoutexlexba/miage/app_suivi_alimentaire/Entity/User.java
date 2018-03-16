package com.zoutexlexba.miage.app_suivi_alimentaire.Entity;

/**
 * Created by Test on 14/03/2018.
 */

public class User {
    private int id;
    private String name;
    private String email;
    private String password;

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

}
