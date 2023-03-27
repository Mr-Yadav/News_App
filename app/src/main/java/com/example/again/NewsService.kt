package com.example.again

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val base_url = "https://newsapi.org/"
//const val api_key = "api_key=4f5aecfc5cdf266177a03ec7c7b2fce0"

interface NewsInsterface {

    @GET("v2/top-headlines?apiKey=864c605dcb6c4c2d9b0e5f114db993ec")

    fun getHeadline(@Query("country") country :String, @Query("category") category:String,@Query("page") page :Int ): Call<News>


}

object NewsService{

    val newsInstance : NewsInsterface

    init {
        val retrofit = Retrofit.Builder().baseUrl(base_url).
                addConverterFactory(GsonConverterFactory.create()).build()


        newsInstance = retrofit.create(NewsInsterface::class.java)


    }



}









