package com.example.currencyexchange;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ChooseAmount.ChooseAmountCallBack, SelectCurrency.SelectCurrencyCallBack, Tax.tax {
private String CurrencyName;
private double exchangeAmt;
private double amount;
private double total;
private double taxamt;
Fragment frag1= new ChooseAmount();
Fragment frag2=new SelectCurrency();
Fragment frag3 = new Tax();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout holder = findViewById(R.id.frame_container);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_container,frag1);
        transaction.add(R.id.frame_container,frag2);
        transaction.add(R.id.frame_container,frag3);
        transaction.hide(frag2);
        transaction.hide(frag3);
        transaction.commit();
    }

    @Override
    public void swapoutamount(double amt) {
        FrameLayout holder = findViewById(R.id.frame_container);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(frag1);
        transaction.show(frag2);
        transaction.hide(frag3);
        amount=amt;
        TextView displayTV= findViewById(R.id.displayTV);
        displayTV.setText("Amount is "+ amt + " dollers");
        transaction.commit();
    }

    @Override
    public void swapoutcurrency(String name,double rate) {
        FrameLayout holder = findViewById(R.id.frame_container);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        TextView displayTV=findViewById(R.id.displayTV);
        CurrencyName=name;
       total=amount*rate;
        displayTV.setText(amount +" dollers is " + total+ " "+CurrencyName);
        transaction.show(frag3);
        transaction.hide(frag1);
        transaction.hide(frag2);
        transaction.commit();
    }
    @Override
    public void swapouttax(int p) {
        FrameLayout holder = findViewById(R.id.frame_container);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        TextView displayTV=findViewById(R.id.displayTV);
        taxamt =total - ((total *p)/100.0);
        displayTV.setText( total+ " "+CurrencyName+" is with out tax \n"+taxamt+" "+CurrencyName+" is with tax");
        transaction.show(frag2);
        transaction.hide(frag1);
        transaction.commit();
    }

}
