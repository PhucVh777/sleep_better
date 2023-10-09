package com.example.sleepbetter.ui.home

import android.os.Bundle
import android.view.View
import com.example.sleepbetter.R
import com.example.sleepbetter.base.BaseFragment
import com.example.sleepbetter.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun getLayout(): Int = R.layout.fragment_home


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}