package com.example.newsapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Articles(
    @SerializedName("author")
    var author: String?= null,
    @SerializedName("title")
    var title: String?= null,
    @SerializedName("description")
    var description: String?= null,
    @SerializedName("url")
    var url: String?= null,
    @SerializedName("urlToImage")
    var imageUrl: String?= null,
    @SerializedName("publishedAt")
    var publishedAt: String?= null,

) : Parcelable