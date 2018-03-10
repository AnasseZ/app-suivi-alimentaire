package com.zoutexlexba.miage.app_suivi_alimentaire.Services;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zoutexlexba.miage.app_suivi_alimentaire.R;

import java.util.ArrayList;
import java.util.HashMap;

import static com.zoutexlexba.miage.app_suivi_alimentaire.Services.Constants.FIRST_COLUMN;
import static com.zoutexlexba.miage.app_suivi_alimentaire.Services.Constants.SECOND_COLUMN;

/**
 * Created by JeanJack on 01/03/2018.
 */

public class ListViewDailyAdapters extends BaseAdapter {

    public ArrayList<HashMap<String, String>> list;
    Activity activity;
    TextView txtFirst;
    TextView txtSecond;
    public ListViewDailyAdapters(Activity activity,ArrayList<HashMap<String, String>> list){
        super();
        this.activity=activity;
        this.list=list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub



        LayoutInflater inflater=activity.getLayoutInflater();

        if(convertView == null){

            convertView=inflater.inflate(R.layout.column_row, null);

            txtFirst=(TextView) convertView.findViewById(R.id.name);
            txtSecond=(TextView) convertView.findViewById(R.id.kcal);

        }

        HashMap<String, String> map=list.get(position);
        txtFirst.setText(map.get(FIRST_COLUMN));
        txtSecond.setText(map.get(SECOND_COLUMN));

        return convertView;
    }
}
