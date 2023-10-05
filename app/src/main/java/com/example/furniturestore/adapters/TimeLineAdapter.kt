package com.example.furniturestore.adapters

import android.content.Context
import android.os.Handler
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.furniturestore.R
import com.example.furniturestore.utilities.Utils
import com.google.android.material.slider.Slider

class TimeLineAdapter(private val dataset: Int, private val context: Context, private var reelPosition: Int) :
    RecyclerView.Adapter<TimeLineAdapter.ViewHolder>() {
    val utils = Utils()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val sldTimeLine: Slider

        init {
            sldTimeLine = view.findViewById(R.id.sldTimeLine)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_timeline, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataset
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val screenSize = utils.getScreenSize(context)
        holder.sldTimeLine.layoutParams.width = (screenSize[0] / (dataset))
        var value = 0
        val maxValue = holder.sldTimeLine.valueTo
        holder.sldTimeLine.value = value.toFloat()

        if (position == reelPosition){
            Thread(Runnable {
                while (value < maxValue) {
                    holder.sldTimeLine.postDelayed(Runnable {
                        if(value < maxValue){
                            value += 1
                            holder.sldTimeLine.value = value.toFloat()
                        } else {
                            value = maxValue.toInt()
                            holder.sldTimeLine.value = value.toFloat()
                        }


                    }, 50)
                    SystemClock.sleep(50)
                }
            }).start()
        }



    }
}