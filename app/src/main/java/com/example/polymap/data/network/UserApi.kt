package com.example.polymap.data.network

import com.example.polymap.data.model.User
import io.reactivex.Observable
import retrofit2.http.GET

interface UserApi {

    @GET("user")
    fun getUser(): Observable<List<User>>
}