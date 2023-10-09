package com.example.sleepbetter.ui.home

import androidx.fragment.app.Fragment
import com.example.sleepbetter.R
import com.example.sleepbetter.base.BaseActivity
import com.example.sleepbetter.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity<ActivityHomeBinding>() {
    override fun getContentView(): Int = R.layout.activity_home


    override fun initView() {
        replaceFragment(HomeFragment())
        mDataBinding.bottomNavMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_sleep -> replaceFragment(HomeFragment())
                R.id.nav_sounds -> replaceFragment(SoundsFragment())
                R.id.nav_statistic -> replaceFragment(StatisticFragment())
                R.id.nav_setting -> replaceFragment(SettingFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }
}