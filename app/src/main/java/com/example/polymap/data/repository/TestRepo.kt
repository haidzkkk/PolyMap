package com.example.polymap.data.repository

import com.example.polymap.data.model.User
import com.example.polymap.data.network.UserApi
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlin.random.Random

class TestRepo(private val api: UserApi) {
    private var number = Random.nextInt()

    fun test(): Observable<String> {
        Thread.sleep(2000)
        return Observable.just("Repository test: $number")
    }

    fun getUsers(): Observable<List<User>> = api.getUser().subscribeOn(Schedulers.io())
}