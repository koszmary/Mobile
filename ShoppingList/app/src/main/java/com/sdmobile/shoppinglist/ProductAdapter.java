package com.symbolite.shoppinglist;  // Dodaj tę linię na górze pliku

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private final List<Product> productList;  // Dodane 'final'

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvName;
        public final CheckBox cbBought;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvProductName);
            cbBought = itemView.findViewById(R.id.cbBought);
        }
    }

    public ProductAdapter(@NonNull List<Product> products) {
        this.productList = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.tvName.setText(product.getName());
        holder.cbBought.setChecked(product.isBought());
        holder.cbBought.setOnCheckedChangeListener((buttonView, isChecked) ->
                product.setBought(isChecked)
        );
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}