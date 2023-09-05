package com.example.polymap.ui.home

import android.util.Log
import com.airbnb.mvrx.Fail
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.ViewModelContext
import com.example.polymap.core.PolyBaseViewModel
import com.example.polymap.data.network.RemoteDataSource
import com.example.polymap.data.network.UserApi
import com.example.polymap.data.repository.TestRepo
import kotlin.random.Random

class HomeViewModel(state: HomeViewState, private val repo: TestRepo)
    : PolyBaseViewModel<HomeViewState, HomeViewAction, HomeViewEvent>(state) {

    override fun handle(action: HomeViewAction) {
        when(action){
            is HomeViewAction.TestViewAction -> handleTestViewACtion()
            is HomeViewAction.GetUserViewAction -> handleGetUsers()
        }
    }

    private fun handleTestViewACtion() {
        setState { copy(test = Loading()) }
        repo.test()
            .execute {
                copy(test = it)
            }
    }

    private fun handleGetUsers() {
        Log.e("TAG", "handleTestViewACtion" )
        setState { copy(users = Loading()) }
        repo.getUsers()
            .execute {
                copy(users = it)
            }
    }

    fun testEvent(){
        _viewEvents.post(HomeViewEvent.testViewEvent)
    }


    companion object : MvRxViewModelFactory<HomeViewModel, HomeViewState> {
        override fun create(viewModelContext: ViewModelContext, state: HomeViewState): HomeViewModel? {
            var repo : TestRepo = TestRepo(RemoteDataSource().buildApi(UserApi::class.java, viewModelContext.activity.applicationContext))
            return HomeViewModel(state, repo)
        }
    }
}

