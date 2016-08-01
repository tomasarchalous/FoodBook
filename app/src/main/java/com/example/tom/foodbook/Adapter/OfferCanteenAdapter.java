package com.example.tom.foodbook.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.tom.foodbook.Canteen;
import com.example.tom.foodbook.R;

import java.util.List;

/**
 * Created by Tomáš on 29.07.2016.
 */

public class OfferCanteenAdapter  extends RecyclerView.Adapter<OfferCanteenAdapter.ViewHolder> {

    public static final String MIBA_TAG = "MIBA_TAG";

    private List<Canteen> canteenList;



    public OfferCanteenAdapter(List<Canteen> canteenList) {
        this.canteenList = canteenList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_offer_canteen, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Canteen food = canteenList.get(position);

        holder.name.setText(food.getName());
    }

    @Override
    public int getItemCount() {
        return canteenList.size();
    }

    public List<Canteen> getCanteenList() {
        return canteenList;
    }

    // representation of one row of RecycleView
    public static class ViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener {

        public TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_canteen_name);
        }

        @Override
        public void onClick(View v) {

        }
    }

}
