package com.example.polymap.core

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.viewbinding.ViewBinding
import io.reactivex.android.schedulers.AndroidSchedulers

abstract class PolyBaseActivity<VB: ViewBinding> : AppCompatActivity() {

    protected lateinit var views: VB

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        views = getBinding()
        setContentView(views.root)

    }

    abstract fun getBinding(): VB

    @SuppressLint("CheckResult")
    protected fun <T : PolyViewEvent> PolyBaseViewModel<*, *, T>.observeViewEvents(observer: (T?) -> Unit) {
        viewEvents
            .observe()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                observer(it)
            }
    }

}