package com.example.furniturestore.adapters

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.furniturestore.R
import com.example.furniturestore.models.StoryReel
import com.example.furniturestore.utilities.Utils

class StoryAdapter(private val dataSet: List<StoryReel>, private val context: Context) :
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
            return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.tvStory.text = item.title
        val res:Resources = context.resources

            val thread = Thread(Runnable {

                val bmp = Utils().getImgScaled(item.image, "");

                holder.ivStory.post(Runnable{
                    holder.ivStory.setImageBitmap(bmp)
                })

            })
        thread.start()







    }

}