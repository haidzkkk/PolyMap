package com.example.polymap.core

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import com.example.polymap.ultis.DataSource
import com.example.polymap.ultis.PublishDataSource

//import com.example.polymap.ultis.DataSource
//import com.example.polymap.ultis.PublishDataSource

abstract class PolyBaseViewModel<S: MvRxState, VA: PolyViewAction, VE: PolyViewEvent>(state: S)
    : BaseMvRxViewModel<S>(state, false) {

//    interface Factory<S : MvRxState> {
//        fun create(state: S): BaseMvRxViewModel<S>
//    }

    protected val _viewEvents = PublishDataSource<VE>()
    val viewEvents: DataSource<VE> = _viewEvents

    abstract fun handle(action: VA)
}
