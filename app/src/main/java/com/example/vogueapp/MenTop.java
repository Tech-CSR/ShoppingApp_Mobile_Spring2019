package com.example.vogueapp;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.vogueapp.adapters.ShopRecyclerViewAdapter;
import com.example.vogueapp.entities.ProductObject;
import com.example.vogueapp.helpers.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MenTop extends AppCompatActivity {
    private static final String TAG = MenTop.class.getSimpleName();

    private RecyclerView shoppingRecyclerView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_top);
//        VideoView videoView =findViewById(R.id.videocover);
//        String path ="android.resource://" + getPackageName() +"/"+R.raw.fashion_men;
////        Uri uri = Uri.parse(path);
////        videoView.setVideoURI(uri);
////
////        MediaController mc = new MediaController(this);
////        videoView.setMediaController(mc);
////        mc.setAnchorView(videoView);
        ImageButton imageButton = (ImageButton) findViewById(R.id.imgcvr);
        registerForContextMenu(imageButton);




        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        shoppingRecyclerView = (RecyclerView)findViewById(R.id.product_list);
        GridLayoutManager mGrid = new GridLayoutManager(MenTop.this, 2);
        shoppingRecyclerView.setLayoutManager(mGrid);
        shoppingRecyclerView.setHasFixedSize(true);
        shoppingRecyclerView.addItemDecoration(new SpacesItemDecoration(2, 12, false));

        ShopRecyclerViewAdapter shopAdapter = new ShopRecyclerViewAdapter(MenTop.this, getAllProductsOnSale());
        shoppingRecyclerView.setAdapter(shopAdapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //Creates a context menu
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "cover image");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //On selected options displays a toast message
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }

    private List<ProductObject> getAllProductsOnSale(){
        //array list to save the product data
        List<ProductObject> products = new ArrayList<ProductObject>();
        products.add(new ProductObject(1, "classic Shirt", R.drawable.men1, "Beautiful sleek black top for casual outfit and evening walk", 20, 38, "Black"));
        products.add(new ProductObject(1, "Brighter bright", R.drawable.men2, "Beautiful sleek black top for casual outfit and evening walk", 20, 38, "Black"));
        products.add(new ProductObject(1, "perfect blue", R.drawable.men3, "Beautiful sleek black top for casual outfit and evening walk", 20, 38, "White"));
        products.add(new ProductObject(1, "Ever green black", R.drawable.men4, "Beautiful sleek black top for casual outfit and evening walk", 20, 38, "Dark Blue"));
        products.add(new ProductObject(1, "Cool color", R.drawable.men5, "Beautiful sleek black top for casual outfit and evening walk", 20, 38, "Spotted Green"));
        products.add(new ProductObject(1, "Fairly Fair", R.drawable.men6, "Beautiful sleek black top for casual outfit and evening walk", 20, 38, "Multi-color"));
        return products;
    }
}
