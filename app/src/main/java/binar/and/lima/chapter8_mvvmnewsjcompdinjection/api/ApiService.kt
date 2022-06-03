package binar.and.lima.chapter8_mvvmnewsjcompdinjection.api

import binar.and.lima.chapter8_mvvmnewsjcompdinjection.data.ResponseNewsItem
import binar.and.lima.chapter8_mvvmnewsjcompdinjection.data.ResponseStafItem
import retrofit2.http.GET

interface ApiService {

    @GET("news")
    suspend fun getAllNews(): List<ResponseNewsItem>
    @GET("staf")
    suspend fun getAllStaff() : List<ResponseStafItem>
}