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

public class ChooseAmount extends Fragment {
    public ChooseAmount() {
        super();
    }
    public interface ChooseAmountCallBack{
        void swapoutamount();
    }
    ChooseAmountCallBack cAmount;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.select_currency,container,false);
        Button btn=v.findViewById(R.id.setcurrencyBTN);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ChooseAmount ","Amount was entered");
                cAmount.swapoutamount();
            }
        });
        return v;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        cAmount = (ChooseAmountCallBack) context;
    }
}
