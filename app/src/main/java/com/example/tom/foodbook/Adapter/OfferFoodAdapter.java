package com.example.tom.foodbook.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.tom.foodbook.Entity.Food;
import com.example.tom.foodbook.R;

import java.util.List;

/**
 * Created by Mira on 29.7.2016.
 */
public class OfferFoodAdapter extends RecyclerView.Adapter<OfferFoodAdapter.ViewHolder> {

    public static final String MIBA_TAG = "MIBA_TAG";

    private List<Food> foodList;

    // inicialization of adapter
    // pass food data through Constructor on Activity load
    public OfferFoodAdapter(List<Food> foodList) {
        this.foodList = foodList;
    }

    public void setData(List<Food> foodList) {
        Log.d(MIBA_TAG, "OfferFoodAdapter => setData: " + foodList);
        this.foodList.clear();
        this.foodList.addAll(foodList);
        notifyDataSetChanged();
    }

    @Override
    public OfferFoodAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_offer_food, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Food food = foodList.get(position);

        holder.name.setText(food.getName());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    // representation of one row of RecycleView
    public static class ViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener {

        public TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_food_name);
        }

        @Override
        public void onClick(View v) {

        }
    }

}
