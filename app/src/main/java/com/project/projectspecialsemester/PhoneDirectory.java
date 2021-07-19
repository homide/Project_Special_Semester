package com.project.projectspecialsemester;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.ImageView;

import com.project.projectspecialsemester.adapters.PhoneAdapter;

public class PhoneDirectory extends AppCompatActivity {

    ImageView backButton;
    EditText searchRecords;
    RecyclerView phoneRecyclerView;

    //Recursive Calling
    Handler mHandler = new Handler();
    Runnable mRunnable;

    PhoneAdapter phoneAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_directory);

        backButton = findViewById(R.id.back_button);
        searchRecords = findViewById(R.id.search_records);
        phoneRecyclerView = findViewById(R.id.phoneRecycler);

        backButton.setOnClickListener(v->{
            onBackPressed();
        });

        PhoneHashMap phoneHashMap = new PhoneHashMap();

        //This inserts all the data in the given has map
        phoneHashMap.insertPhoneHashMap();

        phoneAdapter = new PhoneAdapter(this,phoneHashMap);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        phoneRecyclerView.setLayoutManager(llm);
        phoneRecyclerView.setAdapter(phoneAdapter);

    }

//    private void startSearchBarScan() {
//
//        mHandler.postDelayed(mRunnable = new Runnable() {
//            @Override
//            public void run() {
//                if(searchRecords.getText()!=null && searchRecords.length()>=2){
//                    filteredCalculators.clear();
//                    String searchString = searchRecords.getText().toString().toLowerCase();
//                    for(Calculator c : calculatorList) {
//                        //Log.d(TAG,"Calculators : "+calculatorList.size());
//                        if (c.getCalculatorTitle().toLowerCase().contains(searchString)) {
//
//                            if(!filteredCalculators.contains(c)){
//                                //Log.d(TAG,"Calculator : "+c.toString());
//                                filteredCalculators.add(c);
//                            }
//
//                        }
//                    }
//                    calculatorsAdapter.notifyDataSetChanged();
//                }
//                else{
//                    if(filteredCalculators.size()>0){
//                        filteredCalculators.clear();
//                    }
//                    filteredCalculators.addAll(calculatorList);
//                    calculatorsAdapter.notifyDataSetChanged();
//                }
//                mHandler.postDelayed(mRunnable, 500L);
//            }
//        }, 500L);
//
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}