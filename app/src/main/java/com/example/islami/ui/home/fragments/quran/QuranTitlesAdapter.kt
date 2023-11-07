package com.example.islami.ui.home.fragments.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.QuranTitlesItemBinding

class QuranTitlesAdapter(var titles:List<String>?=null):RecyclerView.Adapter<QuranTitlesAdapter.ViewHolder>(){
    class ViewHolder(val viewBinding:QuranTitlesItemBinding):RecyclerView.ViewHolder(viewBinding.root){
        fun bind(title:String){
            viewBinding.soraTitle.text = title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = QuranTitlesItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return titles?.size?:0
    }
    var onItemClickListener:OnItemClickListener?=null
   fun interface OnItemClickListener{
        fun onItemClick(position: Int,name:String)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(onItemClickListener!=null&&titles!=null){
            holder.viewBinding.root.setOnClickListener{
                onItemClickListener?.onItemClick(position =position, name = titles!!.get(position)  )
            }
        }
        holder.bind(titles?.get(position)!!)
    }


    fun bindItems(addedTitles: List<String>) {
       titles = addedTitles
    }
}