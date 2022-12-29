package com.geektech.playlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.geektech.playlist.databinding.FragmentSongBinding


class SongFragment : Fragment() {
    private lateinit var binding: FragmentSongBinding

    private val songs: ArrayList<SongModel> = ArrayList<SongModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSongBinding.inflate(layoutInflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(binding.img).load("https://i.pinimg.com/564x/b8/dc/5f/b8dc5f2e94d16eaac4202d92a53df832.jpg")
            .into(binding.img)
        loadData()
        val adapter = PlaylistAdapter(songs, this::onClick)
        binding.songRv.adapter = adapter
    }

    private fun onClick(position: Int){
        val bundle = Bundle()
        bundle.putString("title", songs[position].title.toString())
        bundle.putString("artist",songs[position].artist.toString())
        val secondFragment = SecondFragment()
        val fragmentTransaction: FragmentTransaction =
            activity?.supportFragmentManager?.beginTransaction()!!
        bundle.putString("key", "value") // use as per your need

        secondFragment.setArguments(bundle)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.replace(R.id.fragment_container, secondFragment)
        fragmentTransaction.commit()
    }

    private fun loadData(){
        songs.add(SongModel("yes to heaven", "lana del rey", "3:36"))
        songs.add(SongModel("hard to love", "rose", "2:42"))
        songs.add(SongModel("apocalypse", "cigarettes after sex", "4:51"))
        songs.add(SongModel("m.", "anil", "3:44"))
        songs.add(SongModel("brooklyn baby", "lana del rey", "4:51"))
        songs.add(SongModel("where's my love", "sylm", "3:44"))
        songs.add(SongModel("sex, drugs, etc.", "beach weather", "2:40"))
        songs.add(SongModel("heather", "conan gray", "2:45"))
    }

}