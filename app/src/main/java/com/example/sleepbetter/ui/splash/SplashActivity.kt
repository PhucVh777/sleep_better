package com.example.sleepbetter.ui.splash

import android.animation.ObjectAnimator
import com.example.sleepbetter.R
import com.example.sleepbetter.base.BaseActivity
import com.example.sleepbetter.databinding.ActivitySplashBinding
import com.example.sleepbetter.ui.home.HomeActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    private var currentProgress = 0
    private lateinit var job : Job
    override fun getContentView(): Int = R.layout.activity_splash

    override fun initView() {
        CoroutineScope(Dispatchers.Main).launch {
            rotationView()
            delay(3000)
            mDataBinding!!.ivLoading.clearAnimation()
            showActivity(HomeActivity::class.java)
        }
    }
    private fun rotationView(){
        val rotation = ObjectAnimator.ofFloat(mDataBinding!!.ivLoading, "rotation", 0f, 360f)
        rotation.duration = 1000
        rotation.repeatCount = ObjectAnimator.INFINITE
        rotation.start()
    }
}