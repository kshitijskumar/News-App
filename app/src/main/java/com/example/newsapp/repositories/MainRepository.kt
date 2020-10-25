package com.example.newsapp.repositories

import android.util.Log
import com.example.newsapp.models.Articles
import com.example.newsapp.models.NewsItems
import com.example.newsapp.retrofit.NewsInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val newsInterface: NewsInterface
) {
    var newsItemsResponses = listOf<Articles>()

    suspend fun getNews(type: String) {
        Log.d("getNews func","Func start")
        withContext(Dispatchers.IO){

            try{
                Log.d("getNews func","in try block")
                val response= when(type){
                    "TopHeadlines" -> newsInterface.getTopHeadlines()
                    "Health" -> newsInterface.getHealthNews()
                    "Science" -> newsInterface.getScienceNews()
                    "Entertainment" -> newsInterface.getEntertainmentNews()
                    "Business" -> newsInterface.getBusinessNews()
                    "Sports" -> newsInterface.getSportsNews()
                    else -> newsInterface.getTopHeadlines()
                }
                gotResponse(response)
                Log.d("getNews func","response received")

            }catch (e: Exception){
                Log.d("In Repo catch",e.message!!)
            }
        }
    }

    private fun gotResponse(response: Response<NewsItems>){
        Log.d("In Repo","In thread ${Thread.currentThread().name}")
        if (response.isSuccessful) {
            newsItemsResponses= response.body()!!.newsArticles

        }else{
            Log.d("In repo else","Something went wrong")
        }
    }
}