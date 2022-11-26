package com.akguptaboy.musicplayer.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.akguptaboy.musicplayer.Fragments.FavouritsFragment
import com.akguptaboy.musicplayer.Fragments.MusicsFragment
import com.akguptaboy.musicplayer.Fragments.PlaylistsFragment
import com.akguptaboy.musicplayer.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    var list:ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.add("Musics")
        list.add("Playlists")
        list.add("Favourites")


        binding.viewPager2.adapter = ViewPagerAdapter(this@MainActivity)

        TabLayoutMediator(binding.tabLayout,binding.viewPager2){
                tab,position -> tab.text = list[position]
        }.attach()



    }
    class ViewPagerAdapter(val fragment: FragmentActivity): FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            return when (position){
                0 -> MusicsFragment()
                1 -> PlaylistsFragment()
                else -> FavouritsFragment()
            }

        }

    }
}