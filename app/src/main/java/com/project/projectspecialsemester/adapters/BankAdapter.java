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

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.ViewHolder> {

    LayoutInflater inflater;
    Context context;
    HashMap<Integer, PersonDetails> hashMap;
    ArrayList<Integer> deletedKeys;
    ArrayList<Integer> allKeys;

    public BankAdapter(Context context, HashMap<Integer, PersonDetails> hashMap) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.hashMap = hashMap;
        deletedKeys = new ArrayList<>();
        allKeys = new ArrayList<>();
        allKeys.addAll(hashMap.keySet());
    }

    @NonNull
    @Override
    public BankAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.bank_cardlayout,parent,false);
        return new BankAdapter.ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull BankAdapter.ViewHolder holder, int position) {
        PersonDetails details = hashMap.get(allKeys.get(position));
        holder.name.setText("Name: " + details.getName());
        holder.age.setText("Age: " + details.getAge());
        holder.gender.setText("Gender: " + details.getGender());
        holder.address.setText("Address: " + details.getAddress());
        holder.cvvNum.setText("CVV: " + details.getCVVNumber());
        holder.expDate.setText("Exp Date: " + details.getExpirationDate());
        holder.bankNum.setText("Bank Num: " + details.getBankNumber());

        holder.delete.setOnClickListener(v -> {
            hashMap.remove(allKeys.get(position));
            allKeys.remove(position);
            notifyDataSetChanged();
        });

        holder.update.setOnClickListener(V->{
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            @SuppressLint("InflateParams") View popupView = inflater.inflate(R.layout.bank_insert,null);
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
            EditText bankNumber = popupView.findViewById(R.id.bankET);
            EditText expiration = popupView.findViewById(R.id.expirationET);
            EditText cvv = popupView.findViewById(R.id.cvvET);

            name.setText(details.getName());
            age.setText(String.valueOf(details.getAge()));
            gender.setText(details.getGender());
            address.setText(details.getAddress());
            bankNumber.setText(String.valueOf(details.getBankNumber()));
            expiration.setText(details.getExpirationDate());
            cvv.setText(String.valueOf(details.getCVVNumber()));

            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    hashMap.put(allKeys.get(position), new PersonDetails(name.getText().toString(),Integer.parseInt(age.getText().toString()),gender.getText().toString(),address.getText().toString(),Long.parseLong(bankNumber.getText().toString()),expiration.getText().toString(),Integer.valueOf(cvv.getText().toString())));
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
        TextView name, age, gender, address, bankNum, expDate,cvvNum;
        ImageView delete, update;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.userName);
            age = itemView.findViewById(R.id.userAge);
            gender = itemView.findViewById(R.id.userGender);
            address = itemView.findViewById(R.id.userAddress);
            bankNum = itemView.findViewById(R.id.userBankNum);
            expDate = itemView.findViewById(R.id.userExpDate);
            cvvNum = itemView.findViewById(R.id.usercvvNum);
            delete = itemView.findViewById(R.id.deleteData);
            update = itemView.findViewById(R.id.updateData);
        }
    }
}
