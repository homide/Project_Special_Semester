package com.project.projectspecialsemester;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.projectspecialsemester.adapters.AadhaarAdapter;
import com.project.projectspecialsemester.adapters.PhoneAdapter;

import java.util.HashMap;
import java.util.Map;

public class AadhaarNumber  extends AppCompatActivity {

    ImageView backButton;
    EditText searchRecords;
    RecyclerView phoneRecyclerView;
    FloatingActionButton fab;
    Button searchData;

    AadhaarAdapter aadhaarAdapter;
    AadhaarHashMap aadhaarHashMap;
    HashMap<Integer, PersonDetails> hashMap;

    int a = 25;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadhaar_number);

        backButton = findViewById(R.id.back_button);
        searchRecords = findViewById(R.id.search_records);
        phoneRecyclerView = findViewById(R.id.phoneRecycler);
        fab = findViewById(R.id.floatingButton);
        searchData = findViewById(R.id.searchData);

        backButton.setOnClickListener(v->{
            onBackPressed();
        });

        aadhaarHashMap = new AadhaarHashMap();

        //This inserts all the data in the given has map
        aadhaarHashMap.insertAadhaarHashMap();

        hashMap = aadhaarHashMap.getAadhaarHashMap();

        aadhaarAdapter = new AadhaarAdapter(this,hashMap);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        phoneRecyclerView.setLayoutManager(llm);
        phoneRecyclerView.setAdapter(aadhaarAdapter);

        fab.setOnClickListener(v->{
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            @SuppressLint("InflateParams") View popupView = inflater.inflate(R.layout.aadhaar_insert,null);
            final int width = LinearLayout.LayoutParams.WRAP_CONTENT;
            int height = LinearLayout.LayoutParams.WRAP_CONTENT;
            final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);
            popupWindow.setAnimationStyle(R.style.popup_window_animation);
            popupWindow.setOutsideTouchable(false);
            popupWindow.update();
            popupWindow.showAtLocation(v, Gravity.CENTER,0,0);

            Button saveButton = popupView.findViewById(R.id.saveButton);
            Button cancelButton = popupView.findViewById(R.id.cancelButton);

            TextView heading = popupView.findViewById(R.id.title);
            heading.setText("Insert Data");

            EditText name = popupView.findViewById(R.id.nameET);
            EditText age = popupView.findViewById(R.id.ageET);
            EditText gender = popupView.findViewById(R.id.genderET);
            EditText address = popupView.findViewById(R.id.addressET);
            EditText aadharNum = popupView.findViewById(R.id.aadhaarET);

            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    hashMap.put(a, new PersonDetails(name.getText().toString(),Integer.parseInt(age.getText().toString()),gender.getText().toString(),address.getText().toString(),Long.parseLong(aadharNum.getText().toString())));
                    a++;
                    aadhaarAdapter = new AadhaarAdapter(AadhaarNumber.this,hashMap);
                    LinearLayoutManager llm = new LinearLayoutManager(AadhaarNumber.this);
                    llm.setOrientation(RecyclerView.VERTICAL);
                    phoneRecyclerView.setLayoutManager(llm);
                    phoneRecyclerView.setAdapter(aadhaarAdapter);
                    popupWindow.dismiss();
                }
            });

            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    popupWindow.dismiss();
                }
            });

        });

        searchData.setOnClickListener(v->{
            HashMap<Integer, PersonDetails> temp = new HashMap<>();
            if (searchRecords.getText().length() > 0){
                for (Map.Entry<Integer, PersonDetails> entry :hashMap.entrySet()){
                    if (entry.getValue().getName().contains(searchRecords.getText().toString())){
                        temp.put(entry.getKey(),entry.getValue());
                    }
                }
                aadhaarAdapter = new AadhaarAdapter(AadhaarNumber.this,temp);
                LinearLayoutManager llm2 = new LinearLayoutManager(AadhaarNumber.this);
                llm2.setOrientation(RecyclerView.VERTICAL);
                phoneRecyclerView.setLayoutManager(llm2);
                phoneRecyclerView.setAdapter(aadhaarAdapter);
            }else{
                aadhaarAdapter = new AadhaarAdapter(AadhaarNumber.this,hashMap);
                LinearLayoutManager llm2= new LinearLayoutManager(AadhaarNumber.this);
                llm2.setOrientation(RecyclerView.VERTICAL);
                phoneRecyclerView.setLayoutManager(llm2);
                phoneRecyclerView.setAdapter(aadhaarAdapter);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}