package com.example.furniturestore.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.furniturestore.R
import com.example.furniturestore.models.Product
import com.example.furniturestore.utilities.Utils

class ProductRowAdapter (private val dataset: List<Product>, context: Context) :
    RecyclerView.Adapter<ProductRowAdapter.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivProduct: ImageView
        val ivFavorite: ImageView
        val tvPrice: TextView
        val tvDescription: TextView

        init {
            ivProduct = view.findViewById(R.id.ivProduct)
            ivFavorite = view.findViewById(R.id.ivFavorite)
            tvPrice = view.findViewById(R.id.tvPrice)
            tvDescription = view.findViewById(R.id.tvDescription)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =LayoutInflater.from(parent.context).inflate(R.layout.item_product_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val obj:Product = dataset[position]

        holder.tvPrice.text = obj.price.toString()
        holder.tvDescription.text = obj.description

        val thread:Thread = Thread(Runnable {
            val img = obj.prodImg
            val bmp = Utils().getImgScaled(img, "")
            holder.ivProduct.post(Runnable{
                holder.ivProduct.setImageBitmap(bmp)
            })
        })
        thread.start()

    }
}