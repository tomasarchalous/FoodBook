package com.example.tom.foodbook.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tom.foodbook.CsvHelper;
import com.example.tom.foodbook.Entity.Canteen;
import com.example.tom.foodbook.Entity.Food;
import com.example.tom.foodbook.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomáš on 29.07.2016.
 */

public class OfferCanteenAdapter  extends RecyclerView.Adapter<OfferCanteenAdapter.ViewHolder> {

    public static final String MIBA_TAG = "MIBA_TAG";

    private ViewHolder.ClickListener clickListener;
    private List<Canteen> canteenList;
    Context canteensListActivityContext;



    public OfferCanteenAdapter(List<Canteen> canteenList, Context canteensListActivityContext,  ViewHolder.ClickListener clickListener) {
        this.canteenList = canteenList;
        this.canteensListActivityContext = canteensListActivityContext;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_offer_canteen, parent, false);
        return new ViewHolder(itemView, clickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Canteen canteen = canteenList.get(position);

        CsvHelper csvHelper = new CsvHelper(canteensListActivityContext);
        ArrayList<Food> foods = csvHelper.getFoodsOfCanteen(canteen.getId());

        holder.name.setText(canteen.getName());
        holder.buildingName.setText("Building: " + canteen.getBuilding());
        holder.foodCount.setText("Number of food: " + foods.size());

        holder.imageView.setImageResource(canteen.getImageResource(canteensListActivityContext));

    }

    @Override
    public int getItemCount() {
        return canteenList.size();
    }

    public List<Canteen> getCanteenList() {
        return canteenList;
    }

    // representation of one row of RecycleView
    public static class ViewHolder extends RecyclerView.ViewHolder  implements AdapterView.OnClickListener {

        private ViewHolder.ClickListener clickListener;

        public TextView name;
        public TextView buildingName;
        public TextView foodCount;
        public ImageView imageView;


        public ViewHolder(View itemView, ClickListener listener) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_canteen_name);
            buildingName = (TextView) itemView.findViewById(R.id.tv_building_name);
            foodCount = (TextView) itemView.findViewById(R.id.tv_food_count);
            imageView = (ImageView) itemView.findViewById(R.id.canteenImage);


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
