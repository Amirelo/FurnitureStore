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
import com.example.furniturestore.utilities.Utils

class RoomAdapter (private val dataset: Array<String>, private val context:Context):
    RecyclerView.Adapter<RoomAdapter.ViewHolder>() {

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val tvRoom: TextView
        val ivRoom: ImageView

        init {
            tvRoom = view.findViewById(R.id.tvRoom)
            ivRoom = view.findViewById(R.id.ivRoom)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_room,parent,false);
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvRoom.text = dataset[position]
        val res: Resources = context.resources
        val thread: Thread = Thread(Runnable {
            val img = res.getStringArray(R.array.arr_room_images)[position]
            val bmp = Utils().getImg(img)
            holder.ivRoom.post(Runnable{
                holder.ivRoom.setImageBitmap(bmp)
            })
        })
        thread.start()
    }

}