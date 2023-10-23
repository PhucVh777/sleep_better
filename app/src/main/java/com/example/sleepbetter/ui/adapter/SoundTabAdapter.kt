package com.example.sleepbetter.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sleepbetter.ui.sound.AllMusicFragment
import com.example.sleepbetter.ui.sound.ArsmMusicFragment
import com.example.sleepbetter.ui.sound.CalmingMusicFragment
import com.example.sleepbetter.ui.sound.MediationFragment
import com.example.sleepbetter.ui.sound.NatureMusicFragment

class SoundTabAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllMusicFragment()
            1 -> ArsmMusicFragment()
            2 -> NatureMusicFragment()
            3 -> CalmingMusicFragment()
            else -> MediationFragment()
        }
    }

}