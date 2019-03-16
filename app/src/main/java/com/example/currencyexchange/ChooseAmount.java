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

public class ChooseAmount extends Fragment {
    private int amount;

    public ChooseAmount() {
        super();
    }
    public interface ChooseAmountCallBack{
        void swapoutamount(int amount);
    }
    ChooseAmountCallBack cAmount;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.choose_amount,container,false);
        Button btn=v.findViewById(R.id.setcurrencyBTN);
      final EditText amt= (EditText) v.findViewById(R.id.editText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p=amt.getText().toString();
               amount=Integer.parseInt(p);
                Log.d("ChooseAmount ","Amount was entered");
                cAmount.swapoutamount(amount);
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
