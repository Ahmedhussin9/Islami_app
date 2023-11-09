package com.example.islami.ui.home.activites.soraDetailss

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemVerseBinding

class VersesAdapter(val verses:List<String>):RecyclerView.Adapter<VersesAdapter.ViewHolder>() {
    class ViewHolder(val viewBinding:ItemVerseBinding):RecyclerView.ViewHolder(viewBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemVerseBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return verses.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.content.text = verses[position]
    }
}