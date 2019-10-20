package com.featmov.serles.featuremovie.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass

abstract class BaseVMFragment<VM : ViewModel, B : ViewDataBinding> : BaseFragment<B>() {

    protected lateinit var viewModel: VM

    abstract fun getViewModelClass(): KClass<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    protected open fun initViewModel() {
        viewModel = getViewModel(getViewModelClass())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(BR.viewModel, viewModel)
    }
}