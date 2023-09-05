package com.example.polymap.ui.home

import com.example.polymap.core.PolyViewAction

sealed class HomeViewAction: PolyViewAction {
    object TestViewAction: HomeViewAction()
    object GetUserViewAction: HomeViewAction()
}