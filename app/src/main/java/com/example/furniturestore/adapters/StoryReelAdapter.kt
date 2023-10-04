package com.example.furniturestore.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.furniturestore.R
import com.example.furniturestore.models.StoryReel
import com.example.furniturestore.utilities.Utils

class StoryReelAdapter (private val dataset: List<StoryReel>, private val context: Context):
    RecyclerView.Adapter<StoryReelAdapter.ViewHolder>(){
    val util = Utils()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivImage: ImageView
        val tvTitle: TextView
        val tvDescription: TextView

        init {
            ivImage = view.findViewById(R.id.ivReel)
            tvTitle = view.findViewById(R.id.tvReelTitle)
            tvDescription = view.findViewById(R.id.tvReelDescription)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_reel, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val reel: StoryReel = dataset[position]

        holder.tvTitle.text = reel.title
        holder.tvDescription.text = reel.description

        val thread = Thread(Runnable {
            var imgBitmap = util.getImgWithSize(reel.image, util.getScreenSize(context))
            holder.ivImage.post(Runnable{
                holder.ivImage.setImageBitmap(imgBitmap)
            })
        })

        thread.start()
    }
}