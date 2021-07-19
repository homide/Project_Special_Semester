package com.project.projectspecialsemester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bankAccount, aadhaarNumber, phoneDirectory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bankAccount = findViewById(R.id.bankAccountsButton);
        aadhaarNumber = findViewById(R.id.aadhaarNumberButton);
        phoneDirectory = findViewById(R.id.phoneDirectoryButton);

        bankAccount.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, BankAccounts.class);
            startActivity(intent);
        });

        aadhaarNumber.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, AadhaarNumber.class);
            startActivity(intent);
        });

        phoneDirectory.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, PhoneDirectory.class);
            startActivity(intent);
        });

    }
}