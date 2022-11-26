package com.akguptaboy.musicplayer.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akguptaboy.musicplayer.Activitys.MainActivity
import com.akguptaboy.musicplayer.Activitys.PlayerActivity
import com.akguptaboy.musicplayer.Adapters.MusicAdapters
import com.akguptaboy.musicplayer.R
import com.akguptaboy.musicplayer.databinding.FragmentMusicsBinding


class MusicsFragment : Fragment() {
    private var _binding:FragmentMusicsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMusicsBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var adapter =MusicAdapters(object : MusicAdapters.itemClickListener{
            override fun itemClicked(position: Int) {
               startActivity(Intent(requireActivity(),PlayerActivity::class.java))
            }

        })
        binding.musicRecyclerview.hasFixedSize()
        binding.musicRecyclerview.adapter=adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}