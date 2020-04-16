package com.example.son;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductMenuFragment extends Fragment {


    public ProductMenuFragment() {
        // Required empty public constructor
    }


    private RecyclerView productMenuRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_menu, container, false);

        productMenuRecyclerView = view.findViewById(R.id.product_menu_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        productMenuRecyclerView.setLayoutManager(linearLayoutManager);

        List<ProductMenuModel> productMenuModelList = new ArrayList<>();
        productMenuModelList.add(new ProductMenuModel("İskender","15 Tl"));
        productMenuModelList.add(new ProductMenuModel("Kelle Paça","15 Tl"));
        productMenuModelList.add(new ProductMenuModel("Pilav","15 Tl"));
        productMenuModelList.add(new ProductMenuModel("Kuru","15 Tl"));
        productMenuModelList.add(new ProductMenuModel("Tarhana","15 Tl"));
        productMenuModelList.add(new ProductMenuModel("Lahana","15 Tl"));
        productMenuModelList.add(new ProductMenuModel("Dolma","15 Tl"));
        productMenuModelList.add(new ProductMenuModel("Sa la","12 Tl"));
        productMenuModelList.add(new ProductMenuModel("As kanka","34 Tl"));
        productMenuModelList.add(new ProductMenuModel("NaPION","45 Tl"));
        productMenuModelList.add(new ProductMenuModel("İii","44 Tl"));

        ProductMenuAdapter productMenuAdapter = new ProductMenuAdapter(productMenuModelList);
        productMenuRecyclerView.setAdapter(productMenuAdapter);
        productMenuAdapter.notifyDataSetChanged();

        return view;
    }

}
