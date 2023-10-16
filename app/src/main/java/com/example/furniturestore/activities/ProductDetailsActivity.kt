package com.example.furniturestore.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.furniturestore.R
import com.example.furniturestore.adapters.ColorAdapter
import com.example.furniturestore.adapters.ProductImagesAdapter
import com.example.furniturestore.models.Product
import com.example.furniturestore.models.ProductColor
import com.example.furniturestore.models.ProductImage
import com.example.furniturestore.utilities.Utils

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var tvPrice: TextView
    private lateinit var tvDescription: TextView
    private lateinit var rcImages: RecyclerView
    private lateinit var rcColors: RecyclerView
    private lateinit var ivBack: ImageView
    private lateinit var ivFavorite: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val utils = Utils()

        tvPrice = findViewById(R.id.tvPrice)
        tvDescription = findViewById(R.id.tvDescription)
        rcImages = findViewById(R.id.rcProdImages)
        rcColors = findViewById(R.id.rcColors)
        ivBack = findViewById(R.id.ivBack)
        ivFavorite = findViewById(R.id.ivFavorite)

        var isFavorite = false

        var prod: Product? = null
        prod = if (android.os.Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra("PRODUCTDETAILS", Product::class.java)
        } else{
            intent.getParcelableExtra("PRODUCTDETAILS")
        }
        Toast.makeText(this@ProductDetailsActivity, prod?.prodName.toString(), Toast.LENGTH_SHORT).show()

        val item1 = ProductImage(1, "https://images.pexels.com/photos/2451264/pexels-photo-2451264.jpeg")
        val item2 = ProductImage(2, "https://images.pexels.com/photos/2647714/pexels-photo-2647714.jpeg")
        val item3 = ProductImage(3, "https://images.pexels.com/photos/2079294/pexels-photo-2079294.jpeg")
        val item4 = ProductImage(4, "https://images.pexels.com/photos/3952048/pexels-photo-3952048.jpeg")

        val imageList = listOf(item1,item2,item3,item4)

        val color1 = ProductColor(1, "Brown", "#A56506")
        val color2 = ProductColor(2, "Blue", "#0629A5")
        val color3 = ProductColor(3, "Black", "#000000")

        val colorList = listOf(color1, color2, color3)

        val prodImageAdapter = ProductImagesAdapter(imageList, applicationContext)
        rcImages.adapter = prodImageAdapter
        rcImages.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)

        val colorAdapter = ColorAdapter(colorList)
        rcColors.adapter = colorAdapter
        rcColors.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)

        val colorDecoration = DividerItemDecoration(applicationContext, DividerItemDecoration.HORIZONTAL)
        colorDecoration.setDrawable(
            ContextCompat.getDrawable(applicationContext, R.drawable.spacing_hor_12)!!
        )
        rcColors.addItemDecoration(colorDecoration)

        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rcImages)

        val price = utils.currencyFormat("vi", "VN", prod?.price)
        tvPrice.text = price
        tvDescription.text = prod?.description

        ivBack.setOnClickListener{
            finish()
        }

        ivFavorite.setOnClickListener{
            isFavorite = !isFavorite
            if (isFavorite){
                ivFavorite.setImageResource(R.drawable.ic_heart_filled)
            } else{
                ivFavorite.setImageResource(R.drawable.ic_heart)
            }

        }

    }
}