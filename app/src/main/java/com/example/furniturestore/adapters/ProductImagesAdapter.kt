package com.example.furniturestore.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.furniturestore.R
import com.example.furniturestore.models.ProductImage
import com.example.furniturestore.utilities.Utils

class ProductImagesAdapter (private val dataset: List<ProductImage>, private val context:Context)
    : RecyclerView.Adapter<ProductImagesAdapter.ViewHolder>(){
    val utils = Utils()
    class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        val ivImage: ImageView

        init {
            ivImage = view.findViewById(R.id.ivProductImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product_images, parent, false))
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = dataset[position]
        var screenSize = utils.getScreenSize(context)
        Thread(Runnable {
            val bmp = utils.getImgWithSize(item.image, screenSize[0], screenSize[0])
            holder.ivImage.post(Runnable{
                holder.ivImage.setImageBitmap(bmp)
            })
        }).start()
    }
}