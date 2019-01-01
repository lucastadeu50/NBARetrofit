package com.example.arlinda.nbaretrofit.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface StatsAPI {

    String BASE_URL = "http://data.nba.net/";
    @Headers("Content-Type: application/json")
    @GET("/prod/v1/2018/players/{personId}_profile.json")
    Call<com.example.arlinda.nbaretrofit.model.stats.Response> getData(@Path("personId") String personId);

}
