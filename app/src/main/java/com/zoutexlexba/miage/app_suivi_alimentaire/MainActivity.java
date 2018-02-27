package com.zoutexlexba.miage.app_suivi_alimentaire;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.zoutexlexba.miage.app_suivi_alimentaire.Activities.DailyActivity;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.FoodConsumed;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Day;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.DatabaseHelper;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Food;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.FoodAdapter;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.HttpHandler;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainActivity extends OrmLiteBaseActivity<DatabaseHelper> {

    private String foodName;

    private String URL_1 = "https://fr.openfoodfacts.org/cgi/search.pl?search_terms=";
    private String URL_2 = "&search_simple=1&action=process&json=1";

    public HttpHandler httpHandler = new HttpHandler();
    public ArrayList<Food> foodList;

    public ArrayList<Food> userFoodList;

    private FoodAdapter foodAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchFoodButton = (Button) findViewById(R.id.searchFoodButton);
        final EditText userInput = (EditText) findViewById(R.id.searchFoodTextInput);

        searchFoodButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                foodName = userInput.getText().toString();
                new ApiCallOperation().execute();
            }
        });

        // ICI en brut la liste de tous les items choisis de l'utilisateur,
        // Il faudra biensûr faire autrement lorsqu'on aura des utilisateurs.
        userFoodList = new ArrayList<>();


        listView = (ListView) findViewById(R.id.foodList);
        listView.setOnItemClickListener(this.getOnItemClickListener());
    }

    /**
     * Gestion du click sur un aliment de la listView
     * @return
     */
    public AdapterView.OnItemClickListener getOnItemClickListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                // Récupération du bon aliment
                final Food foodClicked = foodList.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(foodClicked.getNutrimentDescription())
                        .setTitle(foodClicked.getUsableName());

                final EditText quantityInput = new EditText(MainActivity.this);

                // Bouton Valider
                builder.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        // On attribue la quantité choisi à l'aliment
                        float quantityConsumed =  Float.parseFloat(quantityInput.getText().toString());

                        //persistance du choix
                        //persistance de la classe food
                        RuntimeExceptionDao<Food, Integer> foodDao = getHelper().getFoodRuntimeDao();
                        foodDao.create(foodClicked);

                        //ajout de la journee
                        RuntimeExceptionDao<Day, String> journeeDao = getHelper().getJourneeRuntimeDao();
                        Day currentDay = journeeDao.queryForId(getIntent().getStringExtra("Date"));
                        if(currentDay == null){
                            currentDay = new Day(getIntent().getStringExtra("Date"));
                            journeeDao.create(currentDay);
                        }


                        //ajout de la consomation
                        RuntimeExceptionDao<FoodConsumed, Integer> consommeDao = getHelper().getConsommeDataDao();

                        FoodConsumed ajoutConsommation= new FoodConsumed(quantityConsumed,foodClicked.getId(),"day", currentDay.getDateJournee());
                        consommeDao.create(ajoutConsommation);

                        Intent intent = new Intent(MainActivity.this, DailyActivity.class);
                        startActivity(intent);
                        finish();

                        //foodClicked.setQuantityConsumed(quantityConsumed);
                        // On ajoute à la list d'aliments consommés l'aliment choisi
                        //userFoodList.add(foodClicked);
                        // Pour débugger
                        //TextView txt = (TextView) findViewById(R.id.debugUserFoodlistSize);
                        //txt.setText(userFoodList.size() + " aliments consommés.");
                        // Idéalement afficher un toast " L'aliment xxx a été ajouté ! "
                    }
                });

                // Fermeture du Dialog
                builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // On ferme le dialog, on fait rien actuellement.
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.setView(quantityInput);
                dialog.show();
            }
        };
    }

    private class ApiCallOperation extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            // API CALL HERE
            String apiResponse = httpHandler.makeServiceCall(URL_1 + foodName + URL_2);
            foodList = httpHandler.getFoodFromJson(apiResponse).foodList;
            return  foodList.size() + " aliments trouvés.";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            // Do things like update the progress bar
        }

        @Override
        /**
         * result est la valeur retournée par doInBackground
         */
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            /*TextView txt = (TextView) findViewById(R.id.outputGson);
            txt.setText(result);*/

            foodAdapter = new FoodAdapter(MainActivity.this, foodList);
            listView.setAdapter(foodAdapter);
        }
    }
}
