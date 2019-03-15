package com.example.currencyexchange;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
private String CurrencyName;
private int exchangeAmt;
private int amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout holder = findViewById(R.id.);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_container,frag);
        transaction.add(R.id.frame_container,frag2);
        transaction.hide(frag2);
        transaction.commit();
    }
}
