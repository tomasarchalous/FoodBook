package com.example.tom.foodbook;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.tom.foodbook.Adapter.OfferCanteenAdapter;
import com.example.tom.foodbook.Entity.Canteen;

import java.util.ArrayList;

public class CanteensListActivity extends AppCompatActivity implements OfferCanteenAdapter.ViewHolder.ClickListener {

    public static final String MIBA_TAG = "MIBA_TAG";

    private ArrayList<Canteen> offerCanteenList;
    private RecyclerView rvOfferCanteen;
    private RecyclerView.LayoutManager offerCanteenLayoutManager;
    private OfferCanteenAdapter offerCanteenAdapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_canteens);

        /* ************************************************************************************** */

        //RecyclerView.ItemDecoration itemDecoration
        rvOfferCanteen = (RecyclerView) findViewById(R.id.rv_offer_canteen);
        rvOfferCanteen.setHasFixedSize(true);
        offerCanteenLayoutManager = new LinearLayoutManager(this);
        rvOfferCanteen.setLayoutManager(offerCanteenLayoutManager);

        /* ************************************************************************************** */

        Canteen food1 = new Canteen(1,"AC1",22.336170, 114.173159 ,"AC1","Canteen near classrooms providing wide range of food");
        Canteen food2 = new Canteen(2,"AC2",22.336170, 114.173159 ,"ACvv1","Cxcvxanteen near classrooms providing wide range of food");


//        offerCanteenList = new ArrayList<>();
//        offerCanteenList.add(food1);
//        offerCanteenList.add(food2);
        CsvHelper csvHelper = new CsvHelper(CanteensListActivity.this);
        this.offerCanteenList = csvHelper.getCanteens();

        offerCanteenAdapter = new OfferCanteenAdapter(offerCanteenList, CanteensListActivity.this, this);
        rvOfferCanteen.setAdapter(offerCanteenAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MIBA_TAG, "CleverFilterActivity START");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MIBA_TAG, "CleverFilterActivity STOP");
    }

    @Override
    public void onItemClick(int position) {
//        Food clickedFood = offerFoodList.get(position);
//        Toast.makeText(this, "You clicked on " + clickedFood.getName() + " !", Toast.LENGTH_SHORT).show();

        Toast.makeText(this, offerCanteenList.get(position).getName(), Toast.LENGTH_SHORT).show();
    }
}
