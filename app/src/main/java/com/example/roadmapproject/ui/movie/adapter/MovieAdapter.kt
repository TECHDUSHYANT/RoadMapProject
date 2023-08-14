package com.example.roadmapproject.ui.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roadmapproject.data.moviedatamodel.MovieDataResponseModel
import com.example.roadmapproject.data.moviedatamodel.MoviesResponse
import com.example.roadmapproject.databinding.ViewHolderSearchListBinding
import javax.inject.Inject

class MovieAdapter  @Inject constructor() : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    var list = mutableListOf<MovieDataResponseModel>()
    fun setContentList(list: List<MovieDataResponseModel>) {
        this.list = list.toMutableList()
        notifyDataSetChanged()
    }
    class MyViewHolder(val viewHolder: ViewHolderSearchListBinding) :
        RecyclerView.ViewHolder(viewHolder.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieAdapter.MyViewHolder {
        val binding =
            ViewHolderSearchListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MyViewHolder, position: Int) {
        holder.viewHolder.movie = this.list[position]

    }

    override fun getItemCount(): Int {
        return this.list.size
    }
}