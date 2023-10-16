package com.example.furniturestore.fragments

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.GestureDetector
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.furniturestore.R
import com.example.furniturestore.activities.ProductDetailsActivity
import com.example.furniturestore.activities.StoryActivity
import com.example.furniturestore.adapters.ProductRowAdapter
import com.example.furniturestore.adapters.RoomAdapter
import com.example.furniturestore.adapters.StoryAdapter
import com.example.furniturestore.models.Product
import com.example.furniturestore.models.StoryReel
import com.example.furniturestore.utilities.Utils

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // initilize
        val rcStories: RecyclerView = view.findViewById(R.id.rcStories)
        val rcRooms: RecyclerView = view.findViewById(R.id.rcRooms)
        val rcPopulars: RecyclerView = view.findViewById(R.id.rcPopulars)
        val res:Resources = resources

        var item1: StoryReel = StoryReel(
            1,
            "https://images.pexels.com/photos/716107/pexels-photo-716107.jpeg",
            "Assorted commemorative plates",
            "Popular wearables from Dubai, United Arab Emirates"
        )
        var item2: StoryReel = StoryReel(
            2,
            "https://images.pexels.com/photos/2767689/pexels-photo-2767689.jpeg",
            "Assorted color yarn lot",
            "New batch of yarns from Centurion, GP, South Africa"
        )
        var item3: StoryReel = StoryReel(
            3,
            "https://images.pexels.com/photos/7147464/pexels-photo-7147464.jpeg",
            "Workshop",
            "Mannequin near sewing machine in workshop"
        )
        var item4: StoryReel = StoryReel(
            4,
            "https://images.pexels.com/photos/4040586/pexels-photo-4040586.jpeg",
            "Crystals",
            "Composition of rose quartz and geode amethyst arranged in row"
        )

        val reelTitleList = listOf<StoryReel>(item1, item2, item3, item4)



        // get data
        val roomDataset = res.getStringArray(R.array.arr_rooms);

        // temp product list
        val obj1 : Product = Product(1, "table", 30000.0, "Is a table","20230928", "https://images.pexels.com/photos/3705540/pexels-photo-3705540.jpeg")
        val obj2 : Product = Product(2, "chair", 207550.0, "Is a chair","20230928", "https://images.pexels.com/photos/2762247/pexels-photo-2762247.jpeg")
        val obj3 : Product = Product(3, "curtain", 239000.0, "Is a curtain","20230928", "https://images.pexels.com/photos/3255244/pexels-photo-3255244.jpeg")
        val obj4 : Product = Product(4, "carpet", 121000.0, "Is a carpet","20230928", "https://images.pexels.com/photos/3705540/pexels-photo-3705540.jpeg")
        val listProducts = listOf(obj1,obj2,obj3,obj4)

        // adapters
        val storyAdapter = StoryAdapter(reelTitleList, requireContext())
        val roomAdapter = RoomAdapter(roomDataset, requireContext())
        val popularAdapter = ProductRowAdapter(listProducts, requireContext())

        rcStories.adapter = storyAdapter
        rcRooms.adapter = roomAdapter
        rcPopulars.adapter = popularAdapter

        // recyclerview direction
        rcStories.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rcRooms.layoutManager = LinearLayoutManager(context)
        rcPopulars.layoutManager = GridLayoutManager(context, 2)


        // space between recyclerview items
        val storyDecoration = DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL)
        storyDecoration.setDrawable(
            ContextCompat.getDrawable(requireContext(), R.drawable.spacing_hor_12)!!
        )
        rcStories.addItemDecoration(storyDecoration)

        val roomDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        roomDecoration.setDrawable(ContextCompat.getDrawable(requireContext(),
            R.drawable.spacing_ver_16
        )!!)
        rcRooms.addItemDecoration(roomDecoration)

        val popularDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        popularDecoration.setDrawable(ContextCompat.getDrawable(requireContext(),
            R.drawable.spacing_ver_16
        )!!)
        rcPopulars.addItemDecoration(popularDecoration)

        // Touch event

        rcStories.addOnItemTouchListener(object: RecyclerView.OnItemTouchListener{
            var gestureDetector = GestureDetector(requireContext(), object : GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapUp(e: MotionEvent): Boolean {
                    return true
                }
            })

            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                var child = rv.findChildViewUnder(e.x, e.y)
                if (child != null && gestureDetector.onTouchEvent(e)){
                    val position = rv.getChildAdapterPosition(child)
                    val intent = Intent(requireContext(), StoryActivity::class.java)
                    intent.putExtra("STORYPOSITION", position)
                    startActivity(intent)
                }
                return false
            }

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
                TODO("Not yet implemented")
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
                TODO("Not yet implemented")
            }
        })

        rcPopulars.addOnItemTouchListener(object: RecyclerView.OnItemTouchListener{
            var gestureDetector = GestureDetector(requireContext(), object: GestureDetector.SimpleOnGestureListener(){
                override fun onSingleTapUp(e: MotionEvent): Boolean {
                    return true
                }
            })

            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                var child = rv.findChildViewUnder(e.x, e.y)
                if (child != null && gestureDetector.onTouchEvent(e)){
                    var postiion = rv.getChildAdapterPosition(child)
                    var intent = Intent(context, ProductDetailsActivity::class.java)
                    intent.putExtra("PRODUCTDETAILS", obj1)
                    startActivity(intent)
                }

                return false
            }

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
                TODO("Not yet implemented")
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
                TODO("Not yet implemented")
            }
        }
        )


        return view
    }


}