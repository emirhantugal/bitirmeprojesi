package com.example.son;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {

      private ViewPager productImagesViewPager;
      private TabLayout viewpagerIndicator;

      private ViewPager productAciklamaViewpager;
      private TabLayout productAciklamaTablayout;

      private static boolean ALREADY_ADDED_TO_FAVORI = false;
      private FloatingActionButton addToFavoriBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        productImagesViewPager = findViewById(R.id.product_images_viewpager);
        viewpagerIndicator = findViewById(R.id.viewpager_indicator);
        addToFavoriBtn = findViewById(R.id.add_to_favori_btn);
        productAciklamaViewpager = findViewById(R.id.product_aciklama_viewpager);
        productAciklamaTablayout = findViewById(R.id.product_aciklama_tablayout);

        List<Integer> productImages = new ArrayList<>();
        productImages.add(R.drawable.logodeneme);
        productImages.add(R.drawable.ic_sendyesil);
        productImages.add(R.drawable.ic_logout);
        productImages.add(R.drawable.ic_sendkirmizi);

        ProductImagesAdapter productImagesAdapter = new ProductImagesAdapter(productImages);
        productImagesViewPager.setAdapter(productImagesAdapter);

        viewpagerIndicator.setupWithViewPager(productImagesViewPager, true);

        addToFavoriBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          if(ALREADY_ADDED_TO_FAVORI){
              ALREADY_ADDED_TO_FAVORI = false;
                 addToFavoriBtn.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#9e9e9e")));
                }else{
              ALREADY_ADDED_TO_FAVORI = true;
                   addToFavoriBtn.setSupportImageTintList(getResources().getColorStateList(R.color.colorPrimary));
                      }
            }
        });

           productAciklamaViewpager.setAdapter(new ProductAciklamaAdapter(getSupportFragmentManager(),productAciklamaTablayout.getTabCount()));

           productAciklamaViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productAciklamaTablayout));
           productAciklamaTablayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
               @Override
               public void onTabSelected(TabLayout.Tab tab) {
                   productAciklamaViewpager.setCurrentItem(tab.getPosition());
               }

               @Override
               public void onTabUnselected(TabLayout.Tab tab) {

               }

               @Override
               public void onTabReselected(TabLayout.Tab tab) {

               }
           });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.home){
            return true;
        }else if(id == R.id.main_search_icon){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
