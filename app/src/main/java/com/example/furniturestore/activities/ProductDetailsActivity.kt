package com.example.furniturestore.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.furniturestore.R
import com.example.furniturestore.models.Product
import com.example.furniturestore.utilities.Utils

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var tvPrice: TextView
    private lateinit var tvDescription: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val utils = Utils()

        tvPrice = findViewById(R.id.tvPrice)
        tvDescription = findViewById(R.id.tvDescription)

        var prod: Product? = null
        prod = if (android.os.Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra("PRODUCTDETAILS", Product::class.java)
        } else{
            intent.getParcelableExtra("PRODUCTDETAILS")
        }
        Toast.makeText(this@ProductDetailsActivity, prod?.prodName.toString(), Toast.LENGTH_SHORT).show()

        val price = utils.currencyFormat("vi", "VN", prod?.price)
        tvPrice.text = price
        tvDescription.text = prod?.description

    }
}