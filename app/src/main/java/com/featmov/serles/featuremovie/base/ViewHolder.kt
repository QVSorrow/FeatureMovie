package com.featmov.serles.featuremovie.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class ViewHolder <B : ViewDataBinding>(val binding: B) : RecyclerView.ViewHolder(binding.root)
