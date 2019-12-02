package com.example.retrofit_api;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
interface RequestInterface
{

    String baseurl="https://jsonplaceholder.typicode.com";
    @GET("/posts")

    Call<List<hero>> getjson();
}
