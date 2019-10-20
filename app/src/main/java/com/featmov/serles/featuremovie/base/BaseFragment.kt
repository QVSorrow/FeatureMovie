package com.featmov.serles.featuremovie.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<Binding : ViewDataBinding>: Fragment() {

    lateinit var binding: Binding

    protected abstract val layoutId: Int

    abstract fun setupViewModel(binding: Binding)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(layoutInflater, layoutId, container, false)
        setupViewModel(binding)
        binding.executePendingBindings()
        return binding.root
    }
}