package com.example.son;


import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.common.hash.HashingOutputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;



/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {




    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;

    ///////////// Banner Slider
    private ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    private int currentPage = 2;
    private Timer timer;
    final private long DELAY_TIME = 3000;
    final private long PERIOD_TIME = 3000;
    //////////// Banner Slider

    ////////////Strip Ad
    private ImageView stripAdImage;
    private ConstraintLayout stripAdContainet;
    ////////////Strip Ad


    /////////// Horizantal Product Layout (BURASI TRENDLERİN OLDUGU YER LAN)
    private TextView horizantalLayoutTitle;
    private Button horizantalLayoutviewAllBtn;
    private RecyclerView horizantalRecyclerView;
    /////////// Horizantal Product Layout (BURASI TRENDLERİN OLDUGU YER LAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home2, container, false);

        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link", "Anasayfa"));
        categoryModelList.add(new CategoryModel("link", "Restoran"));
        categoryModelList.add(new CategoryModel("link", "Cafe"));
        categoryModelList.add(new CategoryModel("link", "Meyhane"));
        categoryModelList.add(new CategoryModel("link", "Gece Hayatı"));
        categoryModelList.add(new CategoryModel("link", "Tatlı"));
        categoryModelList.add(new CategoryModel("link", "İçecek"));



         categoryAdapter = new CategoryAdapter(categoryModelList);
         categoryRecyclerView.setAdapter(categoryAdapter);
         categoryAdapter.notifyDataSetChanged();

        ///////////// Banner Slider

        bannerSliderViewPager = view.findViewById(R.id.banner_slider_view_pager);

        sliderModelList = new ArrayList<SliderModel>();

         /////BURADA SLİDER DE GÖZÜKECEK RESİMLER MEVCUT

        sliderModelList.add(new SliderModel(R.drawable.d1));
        sliderModelList.add(new SliderModel(R.drawable.ic_menu_send));

        sliderModelList.add(new SliderModel(R.drawable.ic_sendyesil));
        sliderModelList.add(new SliderModel(R.drawable.ic_sendkirmizi));
        sliderModelList.add(new SliderModel(R.drawable.d1));
        sliderModelList.add(new SliderModel(R.drawable.ic_menu_send));


        sliderModelList.add(new SliderModel(R.drawable.ic_sendyesil));
        sliderModelList.add(new SliderModel(R.drawable.ic_sendkirmizi));
         /////BURADA SLİDER DE GÖZÜKECEK RESİMLER MEVCUT

        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setPageMargin(20);


        bannerSliderViewPager.setCurrentItem(currentPage);


       ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int i, float v, int il) {

           }

           @Override
           public void onPageSelected(int i) {
        currentPage = i;
           }

           @Override
           public void onPageScrollStateChanged(int i) {
              if(i == ViewPager.SCROLL_STATE_IDLE){
                  pageLooper();
              }
           }
       };
         bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);


         startBannerSlideShow();

         bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 pageLooper();
                 stopBannerSlider();
                 if(event.getAction() == MotionEvent.ACTION_UP){
                     startBannerSlideShow();
                 }
                 return false;
             }
         });
        ///////////// Banner Slider

        ////////////Strip Ad
        stripAdImage = view.findViewById(R.id.strip_ad_image);
        stripAdContainet = view.findViewById(R.id.banner_container);

        stripAdImage.setImageResource(R.drawable.d1);

        ////////////Strip Ad


        /////////// Horizantal Product Layout (BURASI TRENDLERİN OLDUGU YER LAN)
         horizantalLayoutTitle = view.findViewById(R.id.h_s_product_title);
         horizantalLayoutviewAllBtn = view.findViewById(R.id.horizantal_scroll_view_all_btn);
         horizantalRecyclerView = view.findViewById(R.id.horizantal_scroll_layout_recyclerview);

         List<HorizantalProductScrollModel> horizantalProductScrollModelList = new ArrayList<>();
         horizantalProductScrollModelList.add(new HorizantalProductScrollModel(R.drawable.ic_sendyesil,"Ali Hocanın MEKANI", "12-15$", "Alkolsüz"));
         horizantalProductScrollModelList.add(new HorizantalProductScrollModel(R.drawable.ic_sendkirmizi,"EMİRHAN MEKANI", "12-15$", "ALKOLLU"));
         horizantalProductScrollModelList.add(new HorizantalProductScrollModel(R.drawable.ic_plus,"BGZ MOTORS", "12-15$", "Alkolsüz"));
         horizantalProductScrollModelList.add(new HorizantalProductScrollModel(R.drawable.ic_search,"ONUR İNCİK", "12-15$", "Alkolsüz"));
         horizantalProductScrollModelList.add(new HorizantalProductScrollModel(R.drawable.ic_account,"CANBERK BEY", "12-15$", "Alkolsüz"));
         horizantalProductScrollModelList.add(new HorizantalProductScrollModel(R.drawable.ic_bell,"FIRAT BEY", "12-15$", "Alkolsüz"));
         horizantalProductScrollModelList.add(new HorizantalProductScrollModel(R.drawable.ic_checklist,"HZ.SASİ", "12-15$", "Alkolsüz"));
         horizantalProductScrollModelList.add(new HorizantalProductScrollModel(R.drawable.home,"OGUZ SASİ", "12-15$", "Alkolsüz"));

         HorizantalProductScrollAdapter horizantalProductScrollAdapter = new HorizantalProductScrollAdapter(horizantalProductScrollModelList);
         LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
         linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
         horizantalRecyclerView.setLayoutManager(linearLayoutManager);
         horizantalRecyclerView.setAdapter(horizantalProductScrollAdapter);
         horizantalProductScrollAdapter.notifyDataSetChanged();
        /////////// Horizantal Product Layout (BURASI TRENDLERİN OLDUGU YER LAN)
        return  view;
    }
    ///////////// Banner Slider
      private  void pageLooper() {
          if (currentPage == sliderModelList.size() - 2) {
              currentPage = 2;
              bannerSliderViewPager.setCurrentItem(currentPage, false);
          }
          if (currentPage == 1) {
              currentPage = sliderModelList.size() - 3;
              bannerSliderViewPager.setCurrentItem(currentPage, false);
          }
          ///////////// Banner Slider
      }

      private void startBannerSlideShow(){
       final Handler handler = new Handler();
       final Runnable update = new Runnable() {
            @Override
            public void run() {
                if(currentPage >= sliderModelList.size()){
                    currentPage = 1;
                }
               bannerSliderViewPager.setCurrentItem(currentPage++,true);
            }
         };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        } , DELAY_TIME, PERIOD_TIME );
      }
      private void stopBannerSlider(){
        timer.cancel();
      }

      ///////////// Banner Slider
}
