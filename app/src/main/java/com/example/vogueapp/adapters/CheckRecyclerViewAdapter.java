package com.example.vogueapp.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vogueapp.R;
import com.example.vogueapp.entities.ProductObject;

import java.util.List;

public class CheckRecyclerViewAdapter extends RecyclerView.Adapter<CheckRecyclerViewHolder> {

    private Context context;
    private double mSubTotal = 0;

    private List<ProductObject> mProductObject;


    public CheckRecyclerViewAdapter(Context context, List<ProductObject> mProductObject) {
        this.context = context;
        this.mProductObject = mProductObject;
    }

    @Override
    public CheckRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Creates a viewholder
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.check_layout, parent, false);
        CheckRecyclerViewHolder productHolder = new CheckRecyclerViewHolder(layoutView);
        return productHolder;
    }

    @Override
    public void onBindViewHolder(CheckRecyclerViewHolder holder, final int position) {
        //get product quantity
        holder.quantity.setText("1");
        holder.productName.setText(mProductObject.get(position).getProductName());
        holder.productPrice.setText(String.valueOf(mProductObject.get(position).getProductPrice()) + " $");

        holder.removeProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Remove the item on remove/button click
                mProductObject.remove(position);

                notifyItemRemoved(position);
                notifyItemRangeChanged(position,mProductObject.size());

                Toast.makeText(context, "Product removed", Toast.LENGTH_LONG).show();
               // Intent checkoutIntent = new Intent(context, CheckoutActivity.class);
//                context.startActivity(new Intent(context, CheckoutActivity.class));
            }
        });
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                CharSequence options[] = new CharSequence[]{
//                        "Remove"
//
//                };
//                AlertDialog.Builder = new AlertDialog.Builder(CheckoutActivity.this);
//
//            }
//        });



    }
//    private double getTotalPrice(List<ProductObject> mProducts){
//        double totalCost = 0;
//        for(int i = 0; i < mProducts.size(); i++){
//            ProductObject pObject = mProducts.get(i);
//            totalCost = totalCost + pObject.getProductPrice();
//        }
//        return totalCost;
//    }



    @Override
    public int getItemCount() {
        return mProductObject.size();
    }
}
