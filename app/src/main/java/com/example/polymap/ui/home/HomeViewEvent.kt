package com.example.polymap.ui.home

import com.example.polymap.core.PolyViewEvent

sealed class HomeViewEvent : PolyViewEvent {
    object testViewEvent: HomeViewEvent()

}