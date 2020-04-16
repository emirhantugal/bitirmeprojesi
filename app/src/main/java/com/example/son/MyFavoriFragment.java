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
public class MyFavoriFragment extends Fragment {


    public MyFavoriFragment() {
        // Required empty public constructor
    }

    private RecyclerView favoriRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_favori, container, false);

        favoriRecyclerView = view.findViewById(R.id.my_favori_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        favoriRecyclerView.setLayoutManager(linearLayoutManager);

        List<FavoriModel> favoriModelList = new ArrayList<>();
        favoriModelList.add(new FavoriModel(R.drawable.ic_heart, "Ali Hocanın Mekanı","3",145,"15-20 Tl","Nakit/Kredi Kartı"));
        favoriModelList.add(new FavoriModel(R.drawable.ic_heart, "Naber la","3",145,"15-20 Tl","Nakit/Kredi Kartı"));
        favoriModelList.add(new FavoriModel(R.drawable.ic_heart, "ii kanki","3",145,"15-20 Tl","Nakit/Kredi Kartı"));
        favoriModelList.add(new FavoriModel(R.drawable.ic_heart, "of bıktım ol","3",145,"15-20 Tl","Nakit/Kredi Kartı"));
        favoriModelList.add(new FavoriModel(R.drawable.ic_heart, "gece saat 3.5","3",145,"15-20 Tl","Nakit/Kredi Kartı"));


        FavoriAdapter favoriAdapter = new FavoriAdapter(favoriModelList);
        favoriRecyclerView.setAdapter(favoriAdapter);
        favoriAdapter.notifyDataSetChanged();

         return view;
    }

}
