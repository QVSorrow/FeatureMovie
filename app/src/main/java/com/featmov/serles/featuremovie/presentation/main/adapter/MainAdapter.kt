package com.featmov.serles.featuremovie.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.featmov.serles.featuremovie.base.BindableAdapter
import com.featmov.serles.featuremovie.base.ViewHolder
import com.featmov.serles.featuremovie.data.remote.responce.MovieItem
import com.featmov.serles.featuremovie.databinding.ItemMainBinding
import com.featmov.serles.featuremovie.presentation.main.MovieClick

class MainAdapter : RecyclerView.Adapter<ViewHolder<ItemMainBinding>>(), BindableAdapter<MutableList<MovieItem>>{

    var list = mutableListOf<MovieItem>()
    lateinit var movieClick: MovieClick

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : ViewHolder<ItemMainBinding> {
        return ViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder : ViewHolder<ItemMainBinding>, position : Int) {
        holder.binding.item = list[position]
        holder.binding.mainItem.setOnClickListener {
            movieClick.onClick(list[position].id)
        }
    }

    override fun setData(data : MutableList<MovieItem>) {
        this.list = data
        notifyDataSetChanged()
    }
}