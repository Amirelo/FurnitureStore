package com.example.furniturestore

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.furniturestore.adapters.StoryAdapter

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val rcStories: RecyclerView = view.findViewById(R.id.rcStories)
        val res:Resources = resources
        val dataset = (res.getStringArray(R.array.arr_stories)+"")
        val storyAdapter = StoryAdapter(dataset, requireContext())

        rcStories.adapter = storyAdapter
        rcStories.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        return view
    }


}