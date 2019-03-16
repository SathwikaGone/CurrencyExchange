package com.example.currencyexchange;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SelectCurrency extends Fragment {
    private double rate;
    private String name;
    public SelectCurrency() {
        super();
    }
    public interface SelectCurrencyCallBack{
        public void swapoutcurrency(String name,double rate);
    }
    SelectCurrencyCallBack scurrency;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.select_currency,container,false);
        Button euro=v.findViewById(R.id.button);
                euro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rate=0.88;
                    name="Euros";
                    Log.d("SelectCurrency ","euro currency was selected");
                    scurrency.swapoutcurrency(name,rate);
                }
            });
                Button pound=v.findViewById(R.id.button2);
                pound.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rate=0.75;
                        name="Pounds";
                        Log.d("SelectCurrency ","pound currency was selected");
                        scurrency.swapoutcurrency(name,rate);
                    }
                });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        scurrency = (SelectCurrencyCallBack) context;
    }

}
