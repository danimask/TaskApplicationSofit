package com.allfile.viewer.free.taskapplication.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.allfile.viewer.free.taskapplication.adapters.PostsAdapter;
import com.allfile.viewer.free.taskapplication.databinding.FragmentPostsBinding;
import com.allfile.viewer.free.taskapplication.model.Posts;
import com.allfile.viewer.free.taskapplication.util.GetDataService;
import com.allfile.viewer.free.taskapplication.util.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsFragment extends Fragment {
    private FragmentPostsBinding binding;
    private PostsAdapter postAdapter;
    private ProgressDialog progressDoalog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPostsBinding.inflate(getLayoutInflater());
        View rootview = binding.getRoot();
        init();
        return rootview;
    }

    private void init() {
        progressDoalog = new ProgressDialog(getContext());
        progressDoalog.setMessage("Loading");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Posts>> call = service.getAllPosts();
        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                progressDoalog.dismiss();
                DataList_retro(response.body());
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(getContext(), "Error...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void DataList_retro(List<Posts> postsList) {
        postAdapter = new PostsAdapter(postsList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.customResyclerView.setLayoutManager(layoutManager);
        binding.customResyclerView.setAdapter(postAdapter);
    }
}
