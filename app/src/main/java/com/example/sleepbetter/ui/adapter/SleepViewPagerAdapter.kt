package com.example.sleepbetter.ui.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.sleepbetter.R
import com.example.sleepbetter.ui.breathing.BreathingActivity
import com.example.sleepbetter.ui.home.HomeActivity
import com.example.sleepbetter.ui.home.ItemBanner

class SleepBannerAdapter(var mContext: Context, var listSleepBanner: MutableList<ItemBanner>) : RecyclerView.Adapter<SleepBannerAdapter.SleepBannerViewHolder>() {
    class SleepBannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgSleepBanner: ImageView = itemView.findViewById(R.id.img_sleep_banner)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepBannerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sleep_banner, parent, false)
        return SleepBannerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listSleepBanner.size
    }

    override fun onBindViewHolder(holder: SleepBannerViewHolder, position: Int) {
        val banner =listSleepBanner.get(position)
        holder.imgSleepBanner.setImageResource(banner.resourceId)
        holder.imgSleepBanner.setOnClickListener {
            when(position){
                0 -> {
                    Log.d("PhucVH", "onBindViewHolder: 0"+position)
                }

                1 -> {
                    mContext.startActivity(Intent(mContext,BreathingActivity::class.java))
                }

                2 -> {
                    Log.d("PhucVH", "onBindViewHolder: 0"+position)
                }

                else -> {
                    Log.d("PhucVH", "onBindViewHolder: 0"+position)
                }
            }
        }
    }

}