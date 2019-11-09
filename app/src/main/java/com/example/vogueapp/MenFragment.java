package com.example.vogueapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenFragment extends Fragment {
    private static final String TAG = MenFragment.class.getSimpleName();
private Button mentop,womentop;
    private RecyclerView shoppingRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_men_fragment, null);
        //inflator is used to access the resource layout content
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        //for fragment view.reference is used
        view.findViewById(R.id.menbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), MenTop.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.womenbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new  Intent(getActivity().getApplication(), WomenTop.class);
                startActivity(intent);

            }
        });


    }



}
