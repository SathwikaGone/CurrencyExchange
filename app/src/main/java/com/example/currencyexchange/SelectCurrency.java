package com.example.currencyexchange;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SelectCurrency extends Fragment {
    public SelectCurrency() {
        super();
    }
    public interface SelectCurrencyCallBack{
        void swapoutcurrency();
    }
    SelectCurrencyCallBack scurrency;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.select_currency,container,false);
        Button euro=v.findViewById(R.id.EuroBTN);
        euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SelectCurrency ","euro currency was selected");
               scurrency.swapoutcurrency();
            }
        });
        Button pound=v.findViewById(R.id.PoundsBTN);
        euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SelectCurrency ","pound currency was selected");
                scurrency.swapoutcurrency();
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
