package com.example.polymap.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.airbnb.mvrx.ActivityViewModelContext
import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxView
import com.airbnb.mvrx.MvRxViewModelProvider
import com.airbnb.mvrx.Success
import com.airbnb.mvrx._fragmentArgsProvider
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.lifecycleAwareLazy
import com.airbnb.mvrx.withState
import com.example.polymap.R
import com.example.polymap.core.PolyBaseFragment
import com.example.polymap.databinding.FragmentHomeBinding
import kotlin.reflect.KClass

class HomeFragment : PolyBaseFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by activityViewModel()

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.observeViewEvents {
            Log.e("TAG", "HomeFragment viewEvent: $it" )
        }

        homeViewModel.handle(HomeViewAction.GetUserViewAction)
    }


    override fun invalidate(): Unit = withState(homeViewModel){
        when(it.users){
            is Loading -> Log.e("TAG", "HomeFragment view state: Loading" )
            is Success -> Log.e("TAG", "HomeFragment view state: Success: ${it.users.invoke() }" )
            else -> {
                Log.e("TAG", "HomeFragment view state: else" )
            }
        }

    }
}
