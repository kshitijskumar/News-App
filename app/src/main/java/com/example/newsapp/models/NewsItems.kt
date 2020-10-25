package com.example.newsapp.models

import com.google.gson.annotations.SerializedName

data class NewsItems(
//    val status: String,
//    val totalResults: Int,
    @SerializedName("articles")
    var newsArticles: List<Articles>
)