package com.example.islami.ui.home.fragments.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemHadethBinding
import com.example.islami.ui.home.model.Hadeth


class HadethRecyclerViewAdapter(private var items:List<Hadeth>?):RecyclerView.Adapter<HadethRecyclerViewAdapter.soraViewHolder>() {
    class soraViewHolder(var viewBinding: ItemHadethBinding):RecyclerView.ViewHolder(viewBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): soraViewHolder {
        val viewBinding = ItemHadethBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return soraViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return items?.size?:0
    }
    var onItemClickListener:OnItemClickListener? = null
   fun interface OnItemClickListener{
        fun onItemClick(position: Int,item: Hadeth)
    }
    fun bindItems(newlist:List<Hadeth>){
        items = newlist
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: soraViewHolder, position: Int) {
        holder.viewBinding.titleHadeth.text = items!![position].title
        if (onItemClickListener!=null){
            holder.viewBinding.root.setOnClickListener{
                onItemClickListener?.onItemClick(position,items!![position])
            }
        }
    }
}