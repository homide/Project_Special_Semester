package com.project.projectspecialsemester.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.projectspecialsemester.PersonDetails;
import com.project.projectspecialsemester.PhoneHashMap;
import com.project.projectspecialsemester.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.ViewHolder> {

    LayoutInflater inflater;
    Context context;
    PhoneHashMap phoneHashMap;
    HashMap<Integer, PersonDetails> hashMap;
    ArrayList<Integer> deletedKeys;
    ArrayList<Integer> allKeys;

    public PhoneAdapter(Context context, PhoneHashMap phoneHashMap) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.phoneHashMap = phoneHashMap;
        hashMap = phoneHashMap.getPhoneHashMap();
        deletedKeys = new ArrayList<>();
        allKeys = new ArrayList<>();
        allKeys.addAll(hashMap.keySet());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.basic_cardlayout,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PersonDetails details = hashMap.get(allKeys.get(position));
        holder.name.setText("Name: " + details.getName());
        holder.age.setText("Age: " + details.getAge());
        holder.gender.setText("Gender: " + details.getGender());
        holder.address.setText("Address: " + details.getAddress());
        holder.ph1.setText("Ph1: " + details.getPhone1());
        holder.ph2.setText("Ph2: " + details.getPhone2());

        holder.delete.setOnClickListener(v -> {
            phoneHashMap.deletePhoneHashMap(allKeys.get(position));
            hashMap.remove(allKeys.get(position));
            allKeys.remove(position);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return hashMap.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, age, gender, address, ph1, ph2;
        ImageView delete, update;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.userName);
            age = itemView.findViewById(R.id.userAge);
            gender = itemView.findViewById(R.id.userGender);
            address = itemView.findViewById(R.id.userAddress);
            ph1 = itemView.findViewById(R.id.userPh1);
            ph2 = itemView.findViewById(R.id.userPh2);
            delete = itemView.findViewById(R.id.deleteData);
            update = itemView.findViewById(R.id.updateData);
        }
    }
}
