package com.featmov.serles.featuremovie.base

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.featmov.serles.featuremovie.R

object BindingAdapter {

    @BindingAdapter(value = ["moviesData"], requireAll = false)
    @JvmStatic
    fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, data: T) {
        if (recyclerView.adapter is BindableAdapter<*>) {
            if (data != null) {
                (recyclerView.adapter as BindableAdapter<T>).setData(data)
            }
        }
    }

    @BindingAdapter(value = ["movieImage"], requireAll = false)
    @JvmStatic
    fun movieImage(view: ImageView, url: String?) {
        view.load(view.context.resources.getString(R.string.img_url) + url)
    }
}