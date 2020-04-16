package com.example.son;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ProductAciklamaAdapter extends FragmentPagerAdapter {


    private int totalTabs;

    public ProductAciklamaAdapter(@NonNull FragmentManager fm, int totalTabs) {
        super(fm);
        this.totalTabs =totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {
        switch ((i)){
            case 0:
               ProductAciklamaFragment productAciklamaFragment = new ProductAciklamaFragment();
               return productAciklamaFragment;
            case 1:
                  ProductMenuFragment productMenuFragment = new ProductMenuFragment();
                  return productMenuFragment;
            case 2:
                ProductAciklamaFragment productAciklamaFragment2 = new ProductAciklamaFragment();
                return productAciklamaFragment2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
