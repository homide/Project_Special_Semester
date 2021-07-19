package com.project.projectspecialsemester.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.projectspecialsemester.PersonDetails;
import com.project.projectspecialsemester.R;

import java.util.ArrayList;
import java.util.HashMap;

public class AadhaarAdapter extends RecyclerView.Adapter<AadhaarAdapter.ViewHolder> {

    LayoutInflater inflater;
    Context context;
    HashMap<Integer, PersonDetails> hashMap;
    ArrayList<Integer> deletedKeys;
    ArrayList<Integer> allKeys;

    public AadhaarAdapter(Context context, HashMap<Integer, PersonDetails> hashMap) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.hashMap = hashMap;
        deletedKeys = new ArrayList<>();
        allKeys = new ArrayList<>();
        allKeys.addAll(hashMap.keySet());
    }

    @NonNull
    @Override
    public AadhaarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.aadhaar_cardlayout,parent,false);
        return new AadhaarAdapter.ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AadhaarAdapter.ViewHolder holder, int position) {
        PersonDetails details = hashMap.get(allKeys.get(position));
        holder.name.setText("Name: " + details.getName());
        holder.age.setText("Age: " + details.getAge());
        holder.gender.setText("Gender: " + details.getGender());
        holder.address.setText("Address: " + details.getAddress());
        holder.aadhaarNum.setText("Aadhaar Number: " + details.getAadhaarNumber());

        holder.delete.setOnClickListener(v -> {
            hashMap.remove(allKeys.get(position));
            allKeys.remove(position);
            notifyDataSetChanged();
        });

        holder.update.setOnClickListener(V->{
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            @SuppressLint("InflateParams") View popupView = inflater.inflate(R.layout.aadhaar_insert,null);
            final int width = LinearLayout.LayoutParams.WRAP_CONTENT;
            int height = LinearLayout.LayoutParams.WRAP_CONTENT;
            final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);
            popupWindow.setAnimationStyle(R.style.popup_window_animation);
            popupWindow.setOutsideTouchable(false);
            popupWindow.update();
            popupWindow.showAtLocation(V, Gravity.CENTER,0,0);

            Button saveButton = popupView.findViewById(R.id.saveButton);
            Button cancelButton = popupView.findViewById(R.id.cancelButton);

            TextView heading = popupView.findViewById(R.id.title);
            heading.setText("Update Data");

            EditText name = popupView.findViewById(R.id.nameET);
            EditText age = popupView.findViewById(R.id.ageET);
            EditText gender = popupView.findViewById(R.id.genderET);
            EditText address = popupView.findViewById(R.id.addressET);
            EditText aadharNum = popupView.findViewById(R.id.aadhaarET);

            name.setText(details.getName());
            age.setText(String.valueOf(details.getAge()));
            gender.setText(details.getGender());
            address.setText(details.getAddress());
            aadharNum.setText(String.valueOf(details.getAadhaarNumber()));

            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    hashMap.put(allKeys.get(position), new PersonDetails(name.getText().toString(),Integer.parseInt(age.getText().toString()),gender.getText().toString(),address.getText().toString(),Long.parseLong(aadharNum.getText().toString())));
                    notifyDataSetChanged();
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
    }

    @Override
    public int getItemCount() {
        return hashMap.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, age, gender, address, aadhaarNum;
        ImageView delete, update;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.userName);
            age = itemView.findViewById(R.id.userAge);
            gender = itemView.findViewById(R.id.userGender);
            address = itemView.findViewById(R.id.userAddress);
            aadhaarNum = itemView.findViewById(R.id.aadhaarNumber);
            delete = itemView.findViewById(R.id.deleteData);
            update = itemView.findViewById(R.id.updateData);
        }
    }
}