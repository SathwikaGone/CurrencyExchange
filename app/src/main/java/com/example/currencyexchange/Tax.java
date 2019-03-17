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
import android.widget.EditText;

public class Tax extends Fragment {
    private int tax1;

    public Tax() {
        super();
    }
    public interface tax{
        void swapouttax(int tax1);
    }
    tax xtax;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.tax,container,false);

        Button btn5=v.findViewById(R.id.taxBTN);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tax1=5;
                Log.d("tax "," 5 percent");
                xtax.swapouttax(tax1);
            }
        });

        Button btn10=v.findViewById(R.id.button2);
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tax1=10;
                Log.d("tax "," 10 percent");
                xtax.swapouttax(tax1);
            }
        });

        Button btn15=v.findViewById(R.id.button3);
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tax1=15;
                Log.d("tax "," 10 percent");
                xtax.swapouttax(tax1);
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        xtax = (tax) context;
    }
}
