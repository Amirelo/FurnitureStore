package com.example.furniturestore.adapters

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.furniturestore.R
import com.example.furniturestore.models.ProductColor
import java.util.zip.Inflater

class ColorAdapter(private val dataset: List<ProductColor>)
    : RecyclerView.Adapter<ColorAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val ivBackground: ImageView
        val ivColor: ImageView
        val tvName: TextView

        init {
            ivBackground = view.findViewById(R.id.ivBackground)
            ivColor = view.findViewById(R.id.ivColor)
            tvName = view.findViewById(R.id.tvName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_color, parent, false))
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: ProductColor = dataset[position]
        holder.tvName.text = item.name

        val thread = Thread(Runnable {
            val colorCode = item.colorCode
            holder.ivColor.post(Runnable{
                var gradDrawable: GradientDrawable = holder.ivColor.background as GradientDrawable
                gradDrawable.setColor(Color.parseColor(colorCode))
            })
        })
        thread.start()
    }
}