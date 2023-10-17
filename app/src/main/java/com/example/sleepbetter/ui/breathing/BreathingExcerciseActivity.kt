package com.example.sleepbetter.ui.breathing

import android.os.CountDownTimer
import android.util.Log
import com.example.sleepbetter.R
import com.example.sleepbetter.base.BaseActivity
import com.example.sleepbetter.databinding.ActivityBreathingExcerciseBinding
import java.util.Locale


class BreathingExcerciseActivity : BaseActivity<ActivityBreathingExcerciseBinding>() {

    val keyBreathingType = "KEY_BREATHING_TYPE"
    val keyBreathingTime = "KEY_BREATHING_TIME"
    var duration = 0
    var excerciseType = 0
    var countDownTimer: CountDownTimer? = null
    override fun getContentView(): Int = R.layout.activity_breathing_excercise

    override fun initView() {
        getTypeAndDuration()
        startTimer(duration)
        mDataBinding.btnBack.setOnClickListener {
            finish()
        }
        mDataBinding.btnStartPauseTimer.setOnClickListener {
            pauseTimer()
        }
        mDataBinding.btnResume.setOnClickListener{

        }
    }

    private fun getTypeAndDuration() {
        val bundle = intent.extras
        if (bundle != null) {
            duration = bundle.getInt(keyBreathingTime)
            excerciseType = bundle.getInt(keyBreathingType)
        }
    }

    private fun startTimer(duration : Int) {
        var durationToMilSec = duration * 60 * 1000
        countDownTimer = object : CountDownTimer(durationToMilSec.toLong(), 1000) {
            override fun onTick(remaining: Long) {
                durationToMilSec = remaining.toInt()
                Log.d("PhucVh", "onTick: "+durationToMilSec)
                updateCountDownText(durationToMilSec)
            }

            override fun onFinish() {
                mDataBinding.tvStatusTimer.setText("Done")
            }

        }.start()
    }

    private fun pauseTimer() {
        countDownTimer?.cancel()
    }
    private fun updateCountDownText(duration: Int) {
        val minutes = (duration / 1000) / 60
        val seconds = (duration / 1000) % 60
        val timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)
        mDataBinding.tvCoundown.setText(timeLeftFormatted)
    }
}