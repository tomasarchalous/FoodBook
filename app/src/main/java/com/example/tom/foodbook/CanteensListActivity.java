package com.example.tom.foodbook;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.tom.foodbook.Adapter.OfferCanteenAdapter;

import java.util.ArrayList;

public class CanteensListActivity extends AppCompatActivity {

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


        offerCanteenList = new ArrayList<>();
        offerCanteenList.add(food1);
        offerCanteenList.add(food2);

        offerCanteenAdapter = new OfferCanteenAdapter(offerCanteenList);
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
}
