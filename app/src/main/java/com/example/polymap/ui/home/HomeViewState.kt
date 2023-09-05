package com.example.polymap.ui.home

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.example.polymap.data.model.User

data class HomeViewState(
    var test : Async<String> = Uninitialized,
    var users : Async<List<User>> = Uninitialized
): MvRxState {
}