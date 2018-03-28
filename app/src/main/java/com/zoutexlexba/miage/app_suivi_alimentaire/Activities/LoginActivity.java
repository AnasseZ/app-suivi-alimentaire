package com.zoutexlexba.miage.app_suivi_alimentaire.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.User;
import com.zoutexlexba.miage.app_suivi_alimentaire.R;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.DatabaseHelper;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.SecurePassword;


public class LoginActivity extends OrmLiteBaseActivity<DatabaseHelper> {
    private static String TABLE_USER = "user";
    private String name,password;
    private EditText txtlogin,txtpwd;
    private Button btnconnection;
    private SecurePassword hashPassword = new SecurePassword();


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //this.deleteDatabase("foodsave.db");
        try {
            if (getHelper().getUserRuntimeDao().queryForAll().isEmpty()) {
                Intent intent = new Intent(LoginActivity.this, CreaAccountActivity.class);
                startActivity(intent);
            }
            else {
                setContentView(R.layout.activity_login);
                txtlogin = (EditText) findViewById(R.id.txtlogin);
                txtpwd = (EditText) findViewById(R.id.txtpwd);
                btnconnection = (Button) findViewById(R.id.btnconnection);
                btnconnection.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {


                        String login = txtlogin.getText().toString().trim();
                        String pwd = txtpwd.getText().toString().trim();
                        if (login.equals("") || pwd.equals("")) {
                            Toast.makeText(getApplicationContext(), "Tous les champs sont requis", Toast.LENGTH_SHORT).show();
                        } else {
                            try {
                                User myUser = getHelper().getUserDao().queryForId(login);

                                if (hashPassword.validatePassword(pwd,myUser.getPassword())) {
                                    Toast.makeText(getApplicationContext(), "Connexion réussie", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this, NavigationActivity.class);
                                    startActivity(intent);
                                } else
                                    Toast.makeText(getApplicationContext(), "Mot de Passe Incorrect", Toast.LENGTH_SHORT).show();
                            }
                            catch(Exception e)
                            {
                                Toast.makeText(getApplicationContext(), "Login Incorrect", Toast.LENGTH_SHORT).show();
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                });

            }
        }
        catch(Exception e)
        {

        }
    }




}
