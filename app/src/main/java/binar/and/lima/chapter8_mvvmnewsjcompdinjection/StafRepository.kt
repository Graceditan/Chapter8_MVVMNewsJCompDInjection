package binar.and.lima.chapter8_mvvmnewsjcompdinjection

import binar.and.lima.chapter8_mvvmnewsjcompdinjection.api.ApiService
import binar.and.lima.chapter8_mvvmnewsjcompdinjection.data.ResponseStafItem
import javax.inject.Inject

class StafRepository @Inject constructor(private val stafapi : ApiService) {

    suspend fun getStaf() : List<ResponseStafItem>{
        return stafapi.getAllStaff()
    }
}