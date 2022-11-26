package com.akguptaboy.musicplayer.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akguptaboy.musicplayer.R

class MusicAdapters(val itemclicklistener: itemClickListener):RecyclerView.Adapter<MusicAdapters.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.music_list_item,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            itemclicklistener.itemClicked(position)
        }

    }

    override fun getItemCount(): Int {
     return 30
    }
    interface itemClickListener{
        fun itemClicked(position: Int)
    }
}