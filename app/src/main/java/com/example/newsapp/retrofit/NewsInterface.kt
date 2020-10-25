package com.example.newsapp.retrofit

import retrofit2.http.GET
import com.example.newsapp.models.NewsItems
import retrofit2.Response

interface NewsInterface {

    @GET("top-headlines?country=in&apiKey=$API_KEY&pageSize=50")
    suspend fun getTopHeadlines(): Response<NewsItems>

    @GET("top-headlines?country=in&apiKey=${Companion.API_KEY}&pageSize=50&category=health")
    suspend fun getHealthNews(): Response<NewsItems>

    @GET("top-headlines?country=in&apiKey=${Companion.API_KEY}&pageSize=50&category=science")
    suspend fun getScienceNews(): Response<NewsItems>

    @GET("top-headlines?country=in&apiKey=${Companion.API_KEY}&pageSize=50&category=entertainment")
    suspend fun getEntertainmentNews(): Response<NewsItems>

    @GET("top-headlines?country=in&apiKey=${Companion.API_KEY}&pageSize=50&category=business")
    suspend fun getBusinessNews(): Response<NewsItems>

    @GET("top-headlines?country=in&apiKey=${Companion.API_KEY}&pageSize=50&category=sports")
    suspend fun getSportsNews(): Response<NewsItems>

    companion object{
        private const val API_KEY= "api key"
    }
}