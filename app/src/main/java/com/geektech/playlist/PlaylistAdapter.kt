package com.geektech.playlist;

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.geektech.playlist.databinding.FragmentSongBinding
import com.geektech.playlist.databinding.FragmentSongItemBinding

public class PlaylistAdapter(
    val songList: ArrayList<SongModel>,
    val onClick: (position: Int)-> Unit
    ): Adapter<PlaylistAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(FragmentSongItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = songList.size

    inner class ViewHolder(private val binding:  FragmentSongItemBinding): RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(){
            val item = songList[adapterPosition]
            binding.apply {
                numberingTv.text = (songList.indexOf(item)+1).toString()
                titleTv.text = item.title
                artistTv.text = item.artist
                duration.text = item.duration }


            itemView.setOnClickListener {
                onClick(adapterPosition)
            }
        }



    }
}


