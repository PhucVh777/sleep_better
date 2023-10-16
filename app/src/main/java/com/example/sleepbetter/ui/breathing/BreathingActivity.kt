package com.example.sleepbetter.ui.breathing

import android.content.Intent
import android.view.View
import com.example.sleepbetter.R
import com.example.sleepbetter.base.BaseActivity
import com.example.sleepbetter.databinding.ActivityBreathingBinding

class BreathingActivity : BaseActivity<ActivityBreathingBinding>() {
    var positionChecked = 0
    val keyBreathingType = "KEY_BREATHING_TYPE"
    override fun getContentView(): Int = R.layout.activity_breathing

    override fun initView() {
        setCheckedButton(0)
        mDataBinding.btnDeepBreathing.setOnClickListener {
            setCheckedButton(0)
        }
        mDataBinding.btnCalmBreathing.setOnClickListener {
            setCheckedButton(1)
        }
        mDataBinding.btnSnoring.setOnClickListener {
            setCheckedButton(2)
        }
        mDataBinding.btnBack.setOnClickListener {
            finish()
        }
        mDataBinding.btnNext.setOnClickListener {
            goNextScreen()
        }
    }

    private fun setCheckedButton(positionChecked: Int) {
        when (positionChecked) {
            0 -> {
                mDataBinding.btnDeepBreathing.setBackgroundResource(R.drawable.bg_btn_breathing_checked)
                mDataBinding.icDeepChecked.visibility = View.VISIBLE
                mDataBinding.btnCalmBreathing.setBackgroundResource(R.drawable.bg_btn_breathing_unchecked)
                mDataBinding.icCalmChecked.visibility = View.GONE
                mDataBinding.btnSnoring.setBackgroundResource(R.drawable.bg_btn_breathing_unchecked)
                mDataBinding.icSnoreChecked.visibility = View.GONE
                this.positionChecked = positionChecked
            }

            1 -> {
                mDataBinding.btnDeepBreathing.setBackgroundResource(R.drawable.bg_btn_breathing_unchecked)
                mDataBinding.icDeepChecked.visibility = View.GONE
                mDataBinding.btnCalmBreathing.setBackgroundResource(R.drawable.bg_btn_breathing_checked)
                mDataBinding.icCalmChecked.visibility = View.VISIBLE
                mDataBinding.btnSnoring.setBackgroundResource(R.drawable.bg_btn_breathing_unchecked)
                mDataBinding.icSnoreChecked.visibility = View.GONE
                this.positionChecked = positionChecked
            }

            2 -> {
                mDataBinding.btnDeepBreathing.setBackgroundResource(R.drawable.bg_btn_breathing_unchecked)
                mDataBinding.icDeepChecked.visibility = View.GONE
                mDataBinding.btnCalmBreathing.setBackgroundResource(R.drawable.bg_btn_breathing_unchecked)
                mDataBinding.icCalmChecked.visibility = View.GONE
                mDataBinding.btnSnoring.setBackgroundResource(R.drawable.bg_btn_breathing_checked)
                mDataBinding.icSnoreChecked.visibility = View.VISIBLE
                this.positionChecked = positionChecked
            }
        }
    }

    private fun goNextScreen() {
        val intent = Intent(this,ChooseTimeActivity::class.java)
        intent.putExtra(keyBreathingType,positionChecked)
        startActivity(intent)
    }
}