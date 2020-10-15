package com.allfile.viewer.free.taskapplication.util;



import com.allfile.viewer.free.taskapplication.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/posts")
    Call<List<Posts>> getAllPosts();
}