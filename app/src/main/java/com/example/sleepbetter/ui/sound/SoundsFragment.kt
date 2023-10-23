package com.example.sleepbetter.ui.sound

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.sleepbetter.R
import com.example.sleepbetter.base.BaseFragment
import com.example.sleepbetter.databinding.FragmentSoundsBinding
import com.example.sleepbetter.ui.adapter.SoundTabAdapter
import com.google.android.material.tabs.TabLayoutMediator

class SoundsFragment : BaseFragment<FragmentSoundsBinding>() {
    private val tabtTitles = arrayListOf("All", "ASMR", "Nature", "Calming", "Meditation")
    override fun getLayout(): Int = R.layout.fragment_sounds
    override fun initView() {
        setupTabLayout()
    }


    private fun setupTabLayout() {
        mBinding?.viewPagerSound?.adapter = SoundTabAdapter(this)
        TabLayoutMediator(
            mBinding!!.tablayoutSoundType,
            mBinding!!.viewPagerSound
        ) { tab, position ->
            tab.text = tabtTitles[position]
        }.attach()
        for (i in 0..3) {
            val textView =
                LayoutInflater.from(requireContext())
                    .inflate(R.layout.tab_music_layout_item, null) as TextView
            mBinding!!.tablayoutSoundType.getTabAt(i)?.customView = textView
        }
    }
}