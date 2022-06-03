package binar.and.lima.chapter8_mvvmnewsjcompdinjection

import binar.and.lima.chapter8_mvvmnewsjcompdinjection.api.ApiService
import binar.and.lima.chapter8_mvvmnewsjcompdinjection.data.ResponseNewsItem
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsapi : ApiService) {

    suspend fun getNews() : List<ResponseNewsItem>{
        return newsapi.getAllNews()
    }
}