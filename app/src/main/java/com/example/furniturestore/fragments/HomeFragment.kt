package com.example.furniturestore.fragments

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.furniturestore.R
import com.example.furniturestore.adapters.ProductRowAdapter
import com.example.furniturestore.adapters.RoomAdapter
import com.example.furniturestore.adapters.StoryAdapter
import com.example.furniturestore.models.Product

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

        // get data
        val storyDataset = (res.getStringArray(R.array.arr_stories)+"")
        val roomDataset = res.getStringArray(R.array.arr_rooms);

        // temp product list
        val obj1 : Product = Product(1, "table", 30000.0, "Is a table","20230928", "https://images.pexels.com/photos/3705540/pexels-photo-3705540.jpeg")
        val obj2 : Product = Product(2, "chair", 207550.0, "Is a chair","20230928", "https://images.pexels.com/photos/2762247/pexels-photo-2762247.jpeg")
        val obj3 : Product = Product(3, "curtain", 239000.0, "Is a curtain","20230928", "https://images.pexels.com/photos/3255244/pexels-photo-3255244.jpeg")
        val obj4 : Product = Product(4, "carpet", 121000.0, "Is a carpet","20230928", "https://images.pexels.com/photos/3705540/pexels-photo-3705540.jpeg")
        val listProducts = listOf(obj1,obj2,obj3,obj4)

        // adapters
        val storyAdapter = StoryAdapter(storyDataset, requireContext())
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


        return view
    }


}