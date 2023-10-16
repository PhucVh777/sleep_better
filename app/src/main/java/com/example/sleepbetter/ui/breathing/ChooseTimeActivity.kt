package com.example.sleepbetter.ui.breathing


import android.content.Intent
import android.os.Bundle
import com.example.sleepbetter.R
import com.example.sleepbetter.base.BaseActivity
import com.example.sleepbetter.databinding.ActivityChooseTimeBinding

class ChooseTimeActivity : BaseActivity<ActivityChooseTimeBinding>() {
    var positionChecked = 0
    val keyBreathingType = "KEY_BREATHING_TYPE"
    val keyBreathingTime = "KEY_BREATHING_TIME"
    var breathingType = 0
    override fun getContentView(): Int = R.layout.activity_choose_time

    override fun initView() {

        breathingType = intent.getIntExtra(keyBreathingType,0)

        setChooseTime(1)
        mDataBinding.btnOneMin.setOnClickListener {
            setChooseTime(1)
        }
        mDataBinding.btnTwoMin.setOnClickListener {
            setChooseTime(2)
        }
        mDataBinding.btnThreeMin.setOnClickListener {
            setChooseTime(3)
        }
        mDataBinding.btnFourMin.setOnClickListener {
            setChooseTime(4)
        }
        mDataBinding.btnDone.setOnClickListener {
            val intent = Intent(this,BreathingExcerciseActivity::class.java)
            val bundle = Bundle()
            bundle.putInt(keyBreathingTime,positionChecked)
            bundle.putInt(keyBreathingType,breathingType)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    private fun setChooseTime(position: Int) {
        when (position) {
            1 -> {
                mDataBinding.btnOneMin.setBackgroundResource(R.drawable.bg_btn_next_breathing)
                mDataBinding.btnTwoMin.setBackgroundResource(R.drawable.bg_btn_choose_time_unselect)
                mDataBinding.btnThreeMin.setBackgroundResource(R.drawable.bg_btn_choose_time_unselect)
                mDataBinding.btnFourMin.setBackgroundResource(R.drawable.bg_btn_choose_time_unselect)
                mDataBinding.btnOneMin.setTextColor(getColor(R.color.white))
                mDataBinding.btnTwoMin.setTextColor(getColor(R.color.color_button_choose_time_unselect))
                mDataBinding.btnThreeMin.setTextColor(getColor(R.color.color_button_choose_time_unselect))
                mDataBinding.btnFourMin.setTextColor(getColor(R.color.color_button_choose_time_unselect))
                positionChecked = position
            }

            2 -> {
                mDataBinding.btnOneMin.setBackgroundResource(R.drawable.bg_btn_choose_time_unselect)
                mDataBinding.btnTwoMin.setBackgroundResource(R.drawable.bg_btn_next_breathing)
                mDataBinding.btnThreeMin.setBackgroundResource(R.drawable.bg_btn_choose_time_unselect)
                mDataBinding.btnFourMin.setBackgroundResource(R.drawable.bg_btn_choose_time_unselect)
                mDataBinding.btnOneMin.setTextColor(getColor(R.color.color_button_choose_time_unselect))
                mDataBinding.btnTwoMin.setTextColor(getColor(R.color.white))
                mDataBinding.btnThreeMin.setTextColor(getColor(R.color.color_button_choose_time_unselect))
                mDataBinding.btnFourMin.setTextColor(getColor(R.color.color_button_choose_time_unselect))
                positionChecked = position
            }

            3 -> {
                mDataBinding.btnOneMin.setBackgroundResource(R.drawable.bg_btn_choose_time_unselect)
                mDataBinding.btnTwoMin.setBackgroundResource(R.drawable.bg_btn_choose_time_unselect)
                mDataBinding.btnThreeMin.setBackgroundResource(R.drawable.bg_btn_next_breathing)
                mDataBinding.btnFourMin.setBackgroundResource(R.drawable.bg_btn_choose_time_unselect)
                mDataBinding.btnOneMin.setTextColor(getColor(R.color.color_button_choose_time_unselect))
                mDataBinding.btnTwoMin.setTextColor(getColor(R.color.color_button_choose_time_unselect))
                mDataBinding.btnThreeMin.setTextColor(getColor(R.color.white))
                mDataBinding.btnFourMin.setTextColor(getColor(R.color.color_button_choose_time_unselect))
                positionChecked = position
            }

            4 -> {
                mDataBinding.btnOneMin.setBackgroundResource(R.drawable.bg_btn_choose_time_unselect)
                mDataBinding.btnTwoMin.setBackgroundResource(R.drawable.bg_btn_choose_time_unselect)
                mDataBinding.btnThreeMin.setBackgroundResource(R.drawable.bg_btn_choose_time_unselect)
                mDataBinding.btnFourMin.setBackgroundResource(R.drawable.bg_btn_next_breathing)
                mDataBinding.btnOneMin.setTextColor(getColor(R.color.color_button_choose_time_unselect))
                mDataBinding.btnTwoMin.setTextColor(getColor(R.color.color_button_choose_time_unselect))
                mDataBinding.btnThreeMin.setTextColor(getColor(R.color.color_button_choose_time_unselect))
                mDataBinding.btnFourMin.setTextColor(getColor(R.color.white))
                positionChecked = position
            }
        }
    }


}