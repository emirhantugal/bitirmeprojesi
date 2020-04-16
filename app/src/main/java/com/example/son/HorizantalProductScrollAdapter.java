package com.example.son;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class HorizantalProductScrollAdapter extends  RecyclerView.Adapter<HorizantalProductScrollAdapter.ViewHolder> {

    private List<HorizantalProductScrollModel> horizantalProductScrollModelList;

    public HorizantalProductScrollAdapter(List<HorizantalProductScrollModel> horizantalProductScrollModelList) {
        this.horizantalProductScrollModelList = horizantalProductScrollModelList;
    }

    @NonNull
    @Override
    public HorizantalProductScrollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizantal_scroll_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizantalProductScrollAdapter.ViewHolder viewHolder, int position) {
         int resource = horizantalProductScrollModelList.get(position).getProduceImage();
         String title = horizantalProductScrollModelList.get(position).getProductTitle();
         String description = horizantalProductScrollModelList.get(position).getProductDescription();
         String alkol = horizantalProductScrollModelList.get(position).getProductAlkol();

         viewHolder.setProductImage(resource);
         viewHolder.setProductTitle(title);
         viewHolder.setProductDescription(description);
         viewHolder.setProductAlkol(alkol);

    }

    @Override
    public int getItemCount() {
        return horizantalProductScrollModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productTitle;
        private TextView productDescription;
        private TextView productAlkol;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.h_s_product_image);
            productTitle = itemView.findViewById(R.id.h_s_product_title);
            productDescription = itemView.findViewById(R.id.h_s_product_description);
            productAlkol = itemView.findViewById(R.id.h_s_product_alkol);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDetailsIntent = new Intent(itemView.getContext(),ProductDetailsActivity.class);
                    itemView.getContext().startActivity(productDetailsIntent);
                }
            });

        }

        private void setProductImage(int resource) {
            productImage.setImageResource(resource);

        }
        private void setProductTitle(String title){
            productTitle.setText(title);
        }
        private void setProductDescription(String description){
            productDescription.setText(description);
        }
        private void setProductAlkol(String alkol){
            productAlkol.setText(alkol);
        }
    }
}
