package com.example.furniturestore

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.furniturestore.adapters.RoomAdapter
import com.example.furniturestore.adapters.StoryAdapter

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val rcStories: RecyclerView = view.findViewById(R.id.rcStories)
        val rcRooms: RecyclerView = view.findViewById(R.id.rcRooms)

        val res:Resources = resources
        val storyDataset = (res.getStringArray(R.array.arr_stories)+"")
        val roomDataset = res.getStringArray(R.array.arr_rooms);

        val storyAdapter = StoryAdapter(storyDataset, requireContext())
        val roomAdapter = RoomAdapter(roomDataset, requireContext())

        rcStories.adapter = storyAdapter
        rcRooms.adapter = roomAdapter

        rcStories.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rcRooms.layoutManager = LinearLayoutManager(context)


        val decoration = DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL)
        decoration.setDrawable(
            ContextCompat.getDrawable(requireContext(), R.drawable.spacing_12_hor)!!
        )
        rcStories.addItemDecoration(decoration)

        return view
    }


}