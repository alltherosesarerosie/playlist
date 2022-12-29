package com.geektech.playlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geektech.playlist.databinding.FragmentSongBinding

class SongItem : Fragment() {
    public lateinit var binding: FragmentSongBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongBinding.inflate(layoutInflater)
        return inflater.inflate(R.layout.fragment_song_item, container, false)
    }



}