package com.example.polymap

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.airbnb.mvrx.viewModel
import com.example.polymap.core.PolyBaseActivity
import com.example.polymap.databinding.ActivityMainBinding
import com.example.polymap.ui.home.HomeViewModel


class MainActivity : PolyBaseActivity<ActivityMainBinding>() {

//    private val homeViewModel: HomeViewModel by viewModel()

    override fun getBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupStatusBar()
        setupBottomNav()


//        homeViewModel.observeViewEvents {
//            Log.e("TAG", "activity viewEvent: ${it}")
//        }
//
//        homeViewModel.testEvent()
    }

    private fun setupStatusBar() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }

    private fun setupBottomNav() {
        val navController = this.findNavController(R.id.fragment_view)
        views.navBottom.setupWithNavController(navController)
    }


}