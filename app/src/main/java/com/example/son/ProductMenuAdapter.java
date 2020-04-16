package com.example.son;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class ProductMenuAdapter extends RecyclerView.Adapter<ProductMenuAdapter.ViewHolder> {

    private List<ProductMenuModel> productMenuModelList;

    public ProductMenuAdapter(List<ProductMenuModel> productMenuModelList) {
        this.productMenuModelList = productMenuModelList;
    }

    @NonNull
    @Override
    public ProductMenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_menu_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductMenuAdapter.ViewHolder viewHolder, int position) {
         String featureTitle = productMenuModelList.get(position).getFeatureNam();
         String featuredail = productMenuModelList.get(position).getFeauteFiyat();
         viewHolder.setFeatures(featureTitle, featuredail);
    }

    @Override
    public int getItemCount() {
        return productMenuModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView featureMenu;
        private TextView featureFiyat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            featureMenu = itemView.findViewById(R.id.menu_isim);
            featureFiyat = itemView.findViewById(R.id.menu_fiyat);
        }
        private void setFeatures(String featureTitle, String featuredail){
          featureMenu.setText(featureTitle);
          featureFiyat.setText(featuredail);
        }

    }
}
