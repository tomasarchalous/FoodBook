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

    private ViewHolder.ClickListener clickListener;
    private List<Food> foodList;

    // inicialization of adapter
    // pass food data through Constructor on Activity load
    public OfferFoodAdapter(List<Food> foodList, ViewHolder.ClickListener clickListener) {
        this.foodList = foodList;
        this.clickListener = clickListener;
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
        return new ViewHolder(itemView, clickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Food food = foodList.get(position);

        holder.name.setText(food.getName());
        holder.calories.setText(food.getCalories() + " kCal");
        holder.price.setText("Price: " + food.getPrice() + " HKD");
        holder.proteins.setText("Proteins: " + food.getProteins() + " g");
        holder.fat.setText("Fats: " + food.getFats() + " g");
        holder.sugar.setText("Sugar: " + food.getSugar() + " g");
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

        private ViewHolder.ClickListener clickListener;
        private TextView name, price, calories, fat, sugar, proteins;

        public ViewHolder(View itemView, ClickListener listener) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_food_name);
            price = (TextView) itemView.findViewById(R.id.tv_food_price);
            calories = (TextView) itemView.findViewById(R.id.tv_food_calories);
            proteins = (TextView) itemView.findViewById(R.id.tv_food_proteins);
            fat = (TextView) itemView.findViewById(R.id.tv_food_fats);
            sugar = (TextView) itemView.findViewById(R.id.tv_food_sugar);

            clickListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition());
        }

        public interface ClickListener {
            void onItemClick(int position);
        }
    }

}
