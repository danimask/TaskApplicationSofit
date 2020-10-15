package com.allfile.viewer.free.taskapplication.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.allfile.viewer.free.taskapplication.databinding.PaymentItemBinding;
import com.allfile.viewer.free.taskapplication.model.DataModel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.ViewHolder> {
    private ArrayList<DataModel> datalist;

    public PaymentAdapter(ArrayList<DataModel> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(PaymentItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataModel datalist_item = datalist.get(position);

        Glide.with(holder.binding.imgView.getContext())
                .load(datalist_item.getImg_id())
                .centerCrop()
                .into(holder.binding.imgView);

        holder.binding.txtView.setText(datalist_item.getImg_txt());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private PaymentItemBinding binding;

        public ViewHolder(PaymentItemBinding mBinding) {
            super(mBinding.getRoot());
            this.binding = mBinding;

        }
    }
}