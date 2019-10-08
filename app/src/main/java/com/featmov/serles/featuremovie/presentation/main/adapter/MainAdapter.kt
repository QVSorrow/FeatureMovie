package com.featmov.serles.featuremovie.presentation.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.featmov.serles.featuremovie.R
import com.featmov.serles.featuremovie.data.remote.responce.MovieItem
import com.featmov.serles.featuremovie.presentation.main.MovieClick

class MainAdapter (private val data : MutableList<MovieItem> = mutableListOf()) : RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    lateinit var movieClick: MovieClick

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder : ViewHolder, position : Int) {
        holder.movieName?.text = data[position].original_title
        holder.movieImage.load(holder.movieImage.context.resources.getString(R.string.img_url) + data[position].poster_path)
        holder.mainItem.setOnClickListener {
            movieClick.onClick(data[position].id)
        }
    }

    fun addItem(paymentItem : MovieItem) {
        data.add(paymentItem)
        notifyItemInserted(data.size)
    }

    fun addItems(paymentItems : List<MovieItem>) {
        data.addAll(paymentItems)
        notifyItemRangeInserted(data.size - paymentItems.size, data.size)
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val movieImage = view.findViewById<ImageView>(R.id.movie_image)
        val movieName = view.findViewById<TextView>(R.id.movie_name)
        val mainItem = view.findViewById<ConstraintLayout>(R.id.mainItem)
    }
}