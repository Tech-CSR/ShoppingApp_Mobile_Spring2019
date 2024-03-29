package com.example.vogueapp.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import  com.example.vogueapp.R;

public class CheckRecyclerViewHolder extends RecyclerView.ViewHolder{

    public TextView quantity, productName, productPrice, removeProduct;

    public CheckRecyclerViewHolder(View itemView) {
        //producct layout reference
        super(itemView);

        quantity = (TextView)itemView.findViewById(R.id.quantity);
        productName =(TextView)itemView.findViewById(R.id.product_name);
        productPrice = (TextView)itemView.findViewById(R.id.product_price);
        removeProduct = (TextView)itemView.findViewById(R.id.remove_from_cart);
    }
}
