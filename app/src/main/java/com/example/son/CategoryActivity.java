package com.example.son;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {


    private RecyclerView categoryRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categoryRecyclerview = findViewById(R.id.category_recyclerview);
        ///////////// Banner Slider

        List<SliderModel>sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.d1));
        sliderModelList.add(new SliderModel(R.drawable.ic_menu_send));

        sliderModelList.add(new SliderModel(R.drawable.ic_sendyesil));
        sliderModelList.add(new SliderModel(R.drawable.ic_sendkirmizi));
        sliderModelList.add(new SliderModel(R.drawable.d1));
        sliderModelList.add(new SliderModel(R.drawable.ic_menu_send));


        sliderModelList.add(new SliderModel(R.drawable.ic_sendyesil));
        sliderModelList.add(new SliderModel(R.drawable.ic_sendkirmizi));
        ///////////// Banner Slider

        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerview.setLayoutManager(testingLayoutManager);


        }



    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.main_search_icon){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
