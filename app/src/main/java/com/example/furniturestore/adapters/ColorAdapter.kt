package com.example.furniturestore.adapters

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.furniturestore.R
import com.example.furniturestore.models.ProductColor

class ColorAdapter(private val dataset: List<ProductColor>, private val selectedPosition: Int)
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
        val bgDrawable: GradientDrawable = holder.ivBackground.background as GradientDrawable
        var gradDrawable: GradientDrawable = holder.ivColor.background as GradientDrawable

        val colorCode = item.colorCode
        gradDrawable.setColor(Color.parseColor(colorCode))

        if (selectedPosition == position){
            bgDrawable.setColor(Color.BLACK)
            holder.tvName.setTextColor(Color.WHITE)
        } else{
            bgDrawable.setColor(Color.WHITE)
            holder.tvName.setTextColor(Color.BLACK)
        }
    }
}