package com.sanre.ui.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.sanre.app.di.ComponentHolder

abstract class BaseFra(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId), UI {

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
        initBindings()
        initEvents()
    }

    override fun initViews() {
    }

    override fun initBindings() {
    }

    override fun initEvents() {
    }

    val api by lazy { ComponentHolder.appComponent.api() }

}