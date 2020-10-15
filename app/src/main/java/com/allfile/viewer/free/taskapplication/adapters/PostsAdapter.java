package com.allfile.viewer.free.taskapplication.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.allfile.viewer.free.taskapplication.databinding.PostItemBinding;
import com.allfile.viewer.free.taskapplication.model.Posts;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {
    private List<Posts> dataList;

    public PostsAdapter(List<Posts> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(PostItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Posts posts = dataList.get(position);

        holder.binding.userId.setText(String.valueOf(posts.getUserId()));
        holder.binding.ID.setText(String.valueOf(posts.getId()));
        holder.binding.title.setText(posts.getTitle());
        holder.binding.body.setText(posts.getBody());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private PostItemBinding binding;

        public ViewHolder(PostItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}