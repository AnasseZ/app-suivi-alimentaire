package com.zoutexlexba.miage.app_suivi_alimentaire.Services;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Food;
import com.zoutexlexba.miage.app_suivi_alimentaire.R;

import java.util.ArrayList;

/**
 * Created by anassezougarh on 31/01/2018.
 */

public class FoodAdapter extends ArrayAdapter<Food> {
    // View lookup cache
    private static class ViewHolder {
        TextView name;
        TextView quantity;
        ImageView foodImg;
    }

    public FoodAdapter(Context context, ArrayList<Food> foodArrayList) {
        super(context, R.layout.list_item, foodArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Food food = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item, parent, false);

            viewHolder.name = (TextView) convertView.findViewById(R.id.foodName);
            viewHolder.quantity = (TextView) convertView.findViewById(R.id.quantity);
            viewHolder.foodImg = (ImageView) convertView.findViewById(R.id.foodImg);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data from the data object via the viewHolder object
        // into the template view.
        viewHolder.name.setText(food.name);
        viewHolder.quantity.setText(food.quantity);
        // Return the completed view to render on screen
        Picasso.with(this.getContext()).load(food.imageUrl).resize(150, 150).into(viewHolder.foodImg);
        return convertView;
    }
}
