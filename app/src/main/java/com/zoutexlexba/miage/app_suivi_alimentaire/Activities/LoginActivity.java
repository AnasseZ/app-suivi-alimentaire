package com.zoutexlexba.miage.app_suivi_alimentaire.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.User;
import com.zoutexlexba.miage.app_suivi_alimentaire.R;
//import com.zoutexlexba.miage.app_suivi_alimentaire.Services.DatabaseHelper;


public class LoginActivity extends AppCompatActivity {
    DatabaseHelper db;
    private static String TABLE_USER = "user";
    private String name,password;
    private EditText txtlogin,txtpwd;
    private Button btnconnection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(true){}
        else{
            setContentView(R.layout.activity_login);

            db = new DatabaseHelper(this);
            txtlogin = (EditText) findViewById(R.id.txtlogin);
            txtpwd = (EditText) findViewById(R.id.txtpwd);
            btnconnection = (Button) findViewById(R.id.btnconnection);
            btnconnection.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    User u1 = new User();
                    String login = txtlogin.getText().toString().trim();
                    String pwd = txtpwd.getText().toString().trim();
                    if (login.equals("") || pwd.equals("")) {
                        Toast.makeText(getApplicationContext(), "Tous les champs sont requis", Toast.LENGTH_SHORT).show();
                    } else {
                        db.addUser(u1);
                        Boolean isuser = db.checkUser(login, pwd);
                        if (isuser) {
                            Toast.makeText(getApplicationContext(), "Connexion réussie", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, NavigationActivity.class);
                            startActivity(intent);
                        } else
                            Toast.makeText(getApplicationContext(), "Login et / ou Mot de Passe Incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }
    }




}
