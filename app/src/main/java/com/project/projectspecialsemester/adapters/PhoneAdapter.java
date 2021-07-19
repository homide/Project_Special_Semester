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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.projectspecialsemester.PersonDetails;
import com.project.projectspecialsemester.PhoneDirectory;
import com.project.projectspecialsemester.PhoneHashMap;
import com.project.projectspecialsemester.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.ViewHolder> {

    LayoutInflater inflater;
    Context context;
    HashMap<Integer, PersonDetails> hashMap;
    ArrayList<Integer> deletedKeys;
    ArrayList<Integer> allKeys;

    public PhoneAdapter(Context context, HashMap<Integer, PersonDetails> hashMap) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.hashMap = hashMap;
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
            hashMap.remove(allKeys.get(position));
            allKeys.remove(position);
            notifyDataSetChanged();
        });

        holder.update.setOnClickListener(V->{
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            @SuppressLint("InflateParams") View popupView = inflater.inflate(R.layout.phone_insert,null);
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
            EditText number1 = popupView.findViewById(R.id.number1ET);
            EditText number2 = popupView.findViewById(R.id.number2ET);

            name.setText(details.getName());
            age.setText(String.valueOf(details.getAge()));
            gender.setText(details.getGender());
            address.setText(details.getAddress());
            number1.setText(String.valueOf(details.getPhone1()));
            number2.setText(String.valueOf(details.getPhone2()));

            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    hashMap.put(allKeys.get(position), new PersonDetails(name.getText().toString(),Integer.parseInt(age.getText().toString()),gender.getText().toString(),address.getText().toString(),Long.parseLong(number1.getText().toString()),Long.parseLong(number2.getText().toString())));
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
