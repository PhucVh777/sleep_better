package com.example.sleepbetter.ui.breathing

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import com.example.sleepbetter.R
import com.example.sleepbetter.base.BaseActivity
import com.example.sleepbetter.databinding.ActivityBreathingExcerciseBinding
import com.example.sleepbetter.ui.home.HomeActivity
import java.util.Locale


class BreathingExcerciseActivity : BaseActivity<ActivityBreathingExcerciseBinding>() {

    val keyBreathingType = "KEY_BREATHING_TYPE"
    val keyBreathingTime = "KEY_BREATHING_TIME"
    var duration = 0
    var excerciseType = 0
    var countDownTimer: CountDownTimerWithPause? = null
    override fun getContentView(): Int = R.layout.activity_breathing_excercise

    override fun initView() {
        getTypeAndDuration()
        checkType(excerciseType)
        startTimer(duration)
        mDataBinding.btnBack.setOnClickListener {
            finish()
        }
        mDataBinding.btnStartPauseTimer.setOnClickListener {
            pauseTimer()
            if (!isFinishing()) {
                showDialogBreath(DIALOG_TYPE_OPPS)
            }
        }

    }

    private fun getTypeAndDuration() {
        val bundle = intent.extras
        if (bundle != null) {
            duration = bundle.getInt(keyBreathingTime)
            excerciseType = bundle.getInt(keyBreathingType)
        }
    }

    private fun startTimer(duration: Int) {
        var durationToMilSec = duration * 60 * 1000
        var durationToSec = duration * 60
        mDataBinding.progressBarTimer.max = durationToSec
        mDataBinding.progressBarTimer.progress = durationToSec
        countDownTimer = object : CountDownTimerWithPause(durationToMilSec.toLong(), 1000, true) {
            override fun onTick(remaining: Long) {
                durationToMilSec = remaining.toInt()
                durationToSec = remaining.toInt() / 1000
                Log.d("PhucVh", "onTick: " + durationToMilSec)
                updateCountDownText(durationToMilSec)
                mDataBinding.progressBarTimer.progress = durationToSec
            }

            override fun onFinish() {
                showDialogBreath(DIALOG_TYPE_CONGRATULATION)
                mDataBinding.progressBarTimer.visibility = View.GONE
                mDataBinding.tvStatusTimer.visibility = View.GONE
            }

        }.create()
    }

    private fun pauseTimer() {
        countDownTimer?.pause()
    }

    private fun updateCountDownText(duration: Int) {
        val minutes = (duration / 1000) / 60
        val seconds = (duration / 1000) % 60
        val timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)
        mDataBinding.tvCoundown.text = timeLeftFormatted
    }

    private fun showDialogBreath(dialogType: Int) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_breathing)
        val window = dialog.window ?: return
        window.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val windowAttributes = window.attributes
        windowAttributes.gravity = Gravity.CENTER
        window.attributes = windowAttributes
        var tvDialogTitle = dialog.findViewById<TextView>(R.id.dialog_breathing_title)
        var tvDialogContent = dialog.findViewById<TextView>(R.id.dialog_breathing_content)
        var btnDialogCancel = dialog.findViewById<TextView>(R.id.btn_cancel)
        var btnDialogYes = dialog.findViewById<TextView>(R.id.btn_yes)

        dialog.setCancelable(false)
        if (dialogType == DIALOG_TYPE_OPPS) {
            tvDialogTitle.text = this.getText(R.string.text_ops)
            tvDialogContent.text = getText(R.string.text_ops_dialog_content)
            btnDialogCancel.setOnClickListener {
                dialog.dismiss()
                countDownTimer?.resume()
            }
            btnDialogYes.setOnClickListener {
                showActivity(HomeActivity::class.java)
                finish()
            }
        } else if (dialogType == DIALOG_TYPE_CONGRATULATION) {
            tvDialogTitle.text = getText(R.string.text_congratulations)
            tvDialogContent.text = getText(R.string.text_congratulation_dialog_content)
            btnDialogCancel.setOnClickListener {
                showActivity(HomeActivity::class.java)
                finish()
            }
            btnDialogYes.setOnClickListener {
                showActivity(BreathingActivity::class.java)
                finish()
            }

        }
        dialog.show()
    }

    private fun checkType(typeBreath: Int) {
        when (typeBreath) {
            0 -> {
                mDataBinding.tvInhale.text = getText(R.string.text_inhale_4s)
                mDataBinding.tvHold.visibility = View.VISIBLE
                mDataBinding.imgArrowHold.visibility = View.VISIBLE
                mDataBinding.tvHold.text = getText(R.string.text_hold_7s)
                mDataBinding.tvExhale.text = getText(R.string.text_exhale_8s)
                setupAnimationForType0()
            }

            1 -> {
                mDataBinding.tvInhale.text = getText(R.string.text_inhale_4s)
                mDataBinding.tvHold.visibility = View.GONE
                mDataBinding.imgArrowHold.visibility = View.GONE
                mDataBinding.tvExhale.text = getText(R.string.text_exhale_4s)
                setupAnimationForType1()
            }

            2 -> {
                mDataBinding.tvInhale.text = getText(R.string.text_inhale_5s)
                mDataBinding.tvHold.visibility = View.GONE
                mDataBinding.imgArrowHold.visibility = View.GONE
                mDataBinding.tvExhale.text = getText(R.string.text_exhale_6s)
                setupAnimationForType2()
            }
        }
    }

    private fun setupAnimationForType1() {
        mDataBinding.imgBreathingGif.addAnimatorUpdateListener { valueAnimator ->
            val progress = (valueAnimator.animatedValue as Float * 100).toInt()
            if (progress <= 21) {
                mDataBinding.tvBreathingType.text = "inhale"

            } else {
                mDataBinding.tvBreathingType.text = "Exhale"

            }
            if (progress == 24) {
                mDataBinding.imgBreathingGif.pauseAnimation()
                mDataBinding.imgBreathingGif.setMinAndMaxProgress(0.57894f, 1f)
                mDataBinding.imgBreathingGif.speed = 2f
                mDataBinding.imgBreathingGif.playAnimation()
                mDataBinding.imgBreathingGif.setMinAndMaxProgress(0.0f, 1f)

            }
            if (progress == 100) {
                mDataBinding.imgBreathingGif.speed = 1f
            }
        }
    }

    private fun setupAnimationForType2() {
        mDataBinding.imgBreathingGif.addAnimatorUpdateListener { valueAnimator ->
            val progress = (valueAnimator.animatedValue as Float * 100).toInt()
            if (progress <= 26) {
                mDataBinding.tvBreathingType.text = "inhale"

            } else {
                mDataBinding.tvBreathingType.text = "Exhale"

            }
            if (progress == 24) {
                mDataBinding.imgBreathingGif.pauseAnimation()
                mDataBinding.imgBreathingGif.setMinAndMaxProgress(0.57894f, 1f)
                mDataBinding.imgBreathingGif.speed = 1.33f
                mDataBinding.imgBreathingGif.playAnimation()
                mDataBinding.imgBreathingGif.setMinAndMaxProgress(0.0f, 1f)

            }
            if (progress == 100) {
                mDataBinding.imgBreathingGif.speed = 1f
            }
        }
    }

    private fun setupAnimationForType0() {
        mDataBinding.imgBreathingGif.addAnimatorUpdateListener { valueAnimator ->
            val progress = (valueAnimator.animatedValue as Float * 100).toInt()
            if (progress <= 21) {
                mDataBinding.tvBreathingType.text = getText(R.string.text_inhale)

            } else if (21 < progress &&progress<= 57) {
                mDataBinding.tvBreathingType.text = getText(R.string.text_hold)
            }else{
                mDataBinding.tvBreathingType.text = getText(R.string.text_exhale)
            }

        }
    }

    companion object {
        val DIALOG_TYPE_OPPS = 1
        val DIALOG_TYPE_CONGRATULATION = 2
    }
}