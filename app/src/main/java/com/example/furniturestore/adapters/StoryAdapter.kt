package com.example.furniturestore.adapters

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.furniturestore.MainActivity
import com.example.furniturestore.R
import com.example.furniturestore.utilities.Utils
import java.net.URL
import java.util.concurrent.Executors

class StoryAdapter(private val dataSet: Array<String>, private val context: Context) :
    RecyclerView.Adapter<StoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvStory: TextView
        val ivStory: ImageView

        init {
            tvStory = view.findViewById(R.id.tv_story)
            ivStory = view.findViewById(R.id.iv_story)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
            return dataSet.size -1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvStory.text = dataSet[position]
        val res:Resources = context.resources

            val thread = Thread(Runnable {
                val img = res.getStringArray(R.array.arr_story_images)[position]

                val bmp = Utils().getImg(img);

                holder.ivStory.post(Runnable{
                    holder.ivStory.setImageBitmap(bmp)
                })

            })
        thread.start()







    }

}