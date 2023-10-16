package com.example.sleepbetter.ui.home

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.sleepbetter.R
import com.example.sleepbetter.base.BaseFragment
import com.example.sleepbetter.databinding.FragmentHomeBinding
import com.example.sleepbetter.ui.adapter.SleepBannerAdapter
import kotlin.math.abs

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private lateinit var listBanner: MutableList<ItemBanner>
    private lateinit var bannerAdapter: SleepBannerAdapter
    private lateinit var compositePageTransformer: CompositePageTransformer
    override fun getLayout(): Int = R.layout.fragment_home
    override fun initView() {
        listBanner = mutableListOf()
        addListbanner()
        bannerAdapter = activity?.let { SleepBannerAdapter(it,listBanner) }!!

        mBinding?.viewPagerSleep?.offscreenPageLimit = 3
        mBinding?.viewPagerSleep?.clipToPadding = false
        mBinding?.viewPagerSleep?.clipChildren = false
        compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1- abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }
        mBinding?.viewPagerSleep?.setPageTransformer(compositePageTransformer)
        mBinding?.viewPagerSleep?.adapter = bannerAdapter
    }

    private fun addListbanner() {
        listBanner.add(ItemBanner(R.drawable.home_tip_sleep))
        listBanner.add(ItemBanner(R.drawable.home_breath_exercises))
        listBanner.add(ItemBanner(R.drawable.home_news))
        listBanner.add(ItemBanner(R.drawable.home_premium_sleep))
    }

}