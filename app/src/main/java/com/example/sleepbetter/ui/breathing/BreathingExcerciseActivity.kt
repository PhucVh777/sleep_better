package com.example.sleepbetter.ui.breathing

import android.widget.Toast
import com.example.sleepbetter.R
import com.example.sleepbetter.base.BaseActivity
import com.example.sleepbetter.databinding.ActivityBreathingExcerciseBinding

class BreathingExcerciseActivity : BaseActivity<ActivityBreathingExcerciseBinding>() {
    val keyBreathingType = "KEY_BREATHING_TYPE"
    val keyBreathingTime = "KEY_BREATHING_TIME"
    var duration = 0
    var excerciseType = 0
    override fun getContentView(): Int = R.layout.activity_breathing_excercise

    override fun initView() {
        getTypeAndDuration()
    }
    private fun getTypeAndDuration(){
        val bundle = intent.extras
        if (bundle!=null){
            duration = bundle.getInt(keyBreathingTime)
            excerciseType = bundle.getInt(keyBreathingType)
        }
        Toast.makeText(this,"duration : "+duration +"min   "+"type = "+excerciseType,Toast.LENGTH_SHORT).show()
    }
}