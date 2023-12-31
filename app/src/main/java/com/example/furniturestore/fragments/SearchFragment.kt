package com.example.furniturestore.fragments

import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.furniturestore.R
import com.example.furniturestore.activities.MainActivity
import com.example.furniturestore.adapters.CategoryAdapter
import com.example.furniturestore.adapters.ProductRowAdapter
import com.example.furniturestore.models.Category
import com.example.furniturestore.models.Product

class SearchFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_search, container, false)
        val rcCategories: RecyclerView = view.findViewById(R.id.rcCategories)
        val rcProducts: RecyclerView = view.findViewById(R.id.rcProducts)
        val llOptions: LinearLayout = view.findViewById(R.id.llOptions)
        val tvTitleCategory: TextView = view.findViewById(R.id.tvTitleCategory)
        val svSearch: AutoCompleteTextView = view.findViewById(R.id.svSearch)

        val activity: MainActivity = context as MainActivity

        // temp category list
        val cate1 = Category(1, "Furniture","https://images.pexels.com/photos/2959583/pexels-photo-2959583.jpeg")
        val cate2 = Category(2, "Lighting","https://images.pexels.com/photos/1123262/pexels-photo-1123262.jpeg")
        val cate3 = Category(3, "Rugs","https://images.pexels.com/photos/6044743/pexels-photo-6044743.jpeg")
        val cate4 = Category(4, "Mirrors","https://images.pexels.com/photos/6186523/pexels-photo-6186523.jpeg")
        val cate5 = Category(5, "Blankets","https://images.pexels.com/photos/821649/pexels-photo-821649.jpeg")
        val cate6 = Category(6, "Cushions","https://images.pexels.com/photos/3757055/pexels-photo-3757055.jpeg")
        val cate7 = Category(7, "Curtains","https://images.pexels.com/photos/462197/pexels-photo-462197.jpeg")
        val cate8 = Category(8, "Baskets","https://images.pexels.com/photos/2113125/pexels-photo-2113125.jpeg")
        val cate9 = Category(9, "Vases","https://images.pexels.com/photos/5825578/pexels-photo-5825578.jpeg")
        val cate10 = Category(10, "Boxes","https://images.pexels.com/photos/793522/pexels-photo-793522.jpeg")

        val listCategory: List<Category> = listOf(cate1,cate2,cate3,cate4,cate5,cate6,cate7,cate8, cate9,cate10)

        // temp product list
        val obj1 = Product(1, "table", 30000.0, "Is a table","20230928", "https://images.pexels.com/photos/3705540/pexels-photo-3705540.jpeg")
        val obj2 = Product(2, "chair", 207550.0, "Is a chair","20230928", "https://images.pexels.com/photos/2762247/pexels-photo-2762247.jpeg")
        val obj3 = Product(3, "curtain", 239000.0, "Is a curtain","20230928", "https://images.pexels.com/photos/3255244/pexels-photo-3255244.jpeg")
        val obj4 = Product(4, "carpet", 121000.0, "Is a carpet","20230928", "https://images.pexels.com/photos/3705540/pexels-photo-3705540.jpeg")
        val listProducts = listOf(obj1,obj2,obj3,obj4)
        val listProductNames = arrayOf(obj1.prodName,obj2.prodName,obj3.prodName,obj4.prodName)

        val categoryAdapter = CategoryAdapter(listCategory)
        val productAdapter = ProductRowAdapter(listProducts, requireContext())

        val searchAdapter = ArrayAdapter(requireContext(), androidx.appcompat.R.layout.select_dialog_item_material, listProductNames)
        svSearch.threshold = 1
        svSearch.setAdapter(searchAdapter)


        rcCategories.adapter = categoryAdapter
        rcProducts.adapter = productAdapter

        rcCategories.layoutManager = LinearLayoutManager(context)
        rcProducts.layoutManager = GridLayoutManager(context, 2)

        val bundle:Bundle = requireArguments()

        val roomTitle = bundle.getString("SEARCHTITLE").toString()
        activity.updateToolbar(roomTitle)



        rcCategories.addOnItemTouchListener(object: RecyclerView.OnItemTouchListener{
            var gestureDetector = GestureDetector(requireContext(), object:GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapUp(e:MotionEvent):Boolean {
                    return true
                }
            })
            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                val child = rv.findChildViewUnder(e.x, e.y)
                if (child != null && gestureDetector.onTouchEvent(e)){
                    val position = rv.getChildAdapterPosition(child)
                    Toast.makeText(requireContext(), listCategory[position].name, Toast.LENGTH_SHORT).show()

                    rcCategories.visibility = View.GONE
                    tvTitleCategory.visibility = View.GONE
                    rcProducts.visibility = View.VISIBLE
                    llOptions.visibility = View.VISIBLE
                }
                return false
            }

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
                Log.d("-------", "Touched")
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
                TODO("Not yet implemented")
            }
        })


        return view
    }

    /*fun backPressed(){
        if (rcCategories.visibility == View.GONE){
            rcCategories.visibility = View.VISIBLE
            rcProducts.visibility = View.GONE
            toolbar.title = roomTitle
        } else{
            parentFragmentManager.popBackStack()
        }
    }*/

}