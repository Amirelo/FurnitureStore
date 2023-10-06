package com.example.furniturestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.furniturestore.R

class FavoriteFragment : Fragment() {
    private lateinit var viewEmpty : View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favorite, container, false)

        viewEmpty = view.findViewById(R.id.view_empty)
        var ivPlaceholder = viewEmpty.findViewById<ImageView>(R.id.ivEmptyPlaceholder)
        var tvPlaceholder1 = viewEmpty.findViewById<TextView>(R.id.tvEmptyPlaceholder1)
        var tvPlaceholder2 = viewEmpty.findViewById<TextView>(R.id.tvEmptyPlaceholder2)

        ivPlaceholder.setImageResource(R.drawable.ic_surprised)
        tvPlaceholder1.text = "nothing saved..."
        tvPlaceholder2.text = "... no worries. Start saving as you shop by clicking the little heart"

        return view
    }

}