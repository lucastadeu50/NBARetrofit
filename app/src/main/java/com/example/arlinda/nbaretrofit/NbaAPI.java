package com.example.arlinda.nbaretrofit;

import com.example.arlinda.nbaretrofit.model.Feed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface NbaAPI {
    String BASE_URL = "http://data.nba.net/";

    @Headers("Content-Type: application/json")
    @GET("/prod/v1/2018/players.json")
    Call<Feed> getData();
}
