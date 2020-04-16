package com.example.son;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavoriAdapter extends RecyclerView.Adapter<FavoriAdapter.ViewHolder> {


    private List<FavoriModel> favoriModelList;

    public FavoriAdapter(List<FavoriModel> favoriModelList) {
        this.favoriModelList = favoriModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.favori_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        int resource = favoriModelList.get(position).getProductImage();
        String title = favoriModelList.get(position).getProductTitle();
        String oylama = favoriModelList.get(position).getOylama();
        int totalRatings = (favoriModelList.get(position).getTotalRatings());
        String productFiyat = favoriModelList.get(position).getProductFiyat();
        String paymentMethod = favoriModelList.get(position).getPaymentMethod();
        viewHolder.setData(resource,title,oylama,totalRatings,productFiyat,paymentMethod);
    }

    @Override
    public int getItemCount() {
        return favoriModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productTitle;
        private TextView oylama;
        private TextView totalRatings;
        private TextView productFiyat;
        private TextView paymentMethod;
        private ImageButton silmeBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productTitle = itemView.findViewById(R.id.product_title);
            oylama = itemView.findViewById(R.id.tv_product_rating_miniview);
            totalRatings = itemView.findViewById(R.id.total_ratings);
            productFiyat = itemView.findViewById(R.id.product_fiyat);
            paymentMethod = itemView.findViewById(R.id.payment_method);
            silmeBtn = itemView.findViewById(R.id.silme_btn);
        }
        @SuppressLint("SetTextI18n")
        private void setData(int resource, String title, String averageRate, int totalRatingsNo, String fiyat, String payMethod){
            productImage.setImageResource(resource);
            productTitle.setText(title);
            oylama.setText(averageRate);
            totalRatings.setText(totalRatingsNo+"(ratings)");
            productFiyat.setText(fiyat);
            paymentMethod.setText(payMethod);


            silmeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),"Sil", Toast.LENGTH_SHORT);
                }
            });

        }

        public void setData(int resource, String title, String oylama, String totalRatings, String productFiyat, String paymentMethod) {
        }
    }
}
