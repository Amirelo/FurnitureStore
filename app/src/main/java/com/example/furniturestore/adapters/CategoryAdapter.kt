package com.example.furniturestore.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.furniturestore.R
import com.example.furniturestore.models.Category
import com.example.furniturestore.utilities.Utils

class CategoryAdapter (private val dataset: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){
    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val ivCategory: ImageView
        val tvCategory: TextView

        init {
            ivCategory = view.findViewById(R.id.ivCategory)
            tvCategory = view.findViewById(R.id.tvCategory)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cate: Category = dataset[position]

        holder.tvCategory.text = cate.name

        val thread: Thread = Thread(Runnable {
            val img = cate.image
            val bmp = Utils().getImgScaled(img)

            holder.ivCategory.post(Runnable{
                holder.ivCategory.setImageBitmap(bmp)
            })
        })
        thread.start()

    }
}