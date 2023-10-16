package com.example.sleepbetter.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B: ViewDataBinding>: Fragment() {
    protected var mBinding: B? = null

    abstract fun getLayout(): Int
    abstract fun initView()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, getLayout(), container, false)
        return mBinding?.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}