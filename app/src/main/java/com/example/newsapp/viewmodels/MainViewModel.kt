package com.example.newsapp.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.models.Articles
import com.example.newsapp.repositories.MainRepository
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val repository: MainRepository
) : ViewModel() {

    val newsItems= MutableLiveData<List<Articles>>()
    fun getNewsFromRepo(type: String){
        viewModelScope.launch {
            repository.getNews(type)
            newsItems.value= repository.newsItemsResponses
        }
    }
}