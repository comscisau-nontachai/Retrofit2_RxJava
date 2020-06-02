package com.becomedev.retrifit2_rxjava.services

import com.becomedev.retrifit2_rxjava.models.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("search/users")
    fun searchUser(@Query("q") q : String?) : Observable<UserResponse>
}