package com.example.furniturestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.furniturestore.adapters.CategoryAdapter
import com.example.furniturestore.models.Category

class SearchFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_search, container, false)
        val rcCategories: RecyclerView = view.findViewById(R.id.rcCategories)

        // Category list
        val cate1 = Category(1, "Furniture","https://images.pexels.com/photos/890669/pexels-photo-890669.jpeg")
        val cate2 = Category(2, "Lighting","https://images.pexels.com/photos/890669/pexels-photo-890669.jpeg")
        val cate3 = Category(3, "Rugs","https://images.pexels.com/photos/890669/pexels-photo-890669.jpeg")
        val cate4 = Category(4, "Mirrors","https://images.pexels.com/photos/890669/pexels-photo-890669.jpeg")
        val cate5 = Category(5, "Blankets","https://images.pexels.com/photos/890669/pexels-photo-890669.jpeg")
        val cate6 = Category(6, "Cushions","https://images.pexels.com/photos/890669/pexels-photo-890669.jpeg")
        val cate7 = Category(7, "Curtains","https://images.pexels.com/photos/890669/pexels-photo-890669.jpeg")
        val cate8 = Category(8, "Baskets","https://images.pexels.com/photos/890669/pexels-photo-890669.jpeg")
        val cate9 = Category(9, "Vases","https://images.pexels.com/photos/890669/pexels-photo-890669.jpeg")
        val cate10 = Category(10, "Boxes","https://images.pexels.com/photos/890669/pexels-photo-890669.jpeg")

        val listCategory: List<Category> = listOf(cate1,cate2,cate3,cate4,cate5,cate6,cate7,cate8, cate9,cate10)

        val categoryAdapter = CategoryAdapter(listCategory)

        rcCategories.adapter = categoryAdapter

        rcCategories.layoutManager = LinearLayoutManager(context)

        return view
    }

}