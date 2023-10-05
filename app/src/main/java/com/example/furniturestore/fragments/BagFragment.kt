package com.example.furniturestore.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.furniturestore.R
import com.example.furniturestore.activities.MainActivity
import com.google.android.material.button.MaterialButton

class BagFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_bag, container, false)

        val viewEmpty = view.findViewById<View>(R.id.viewEmpty)

        val bag = null
        var checkoutButton = view.findViewById<MaterialButton>(R.id.btnCheckout)

        val activity: MainActivity = context as MainActivity

        val iv = viewEmpty.findViewById<ImageView>(R.id.ivEmptyPlaceholder)
        val tv1 = viewEmpty.findViewById<TextView>(R.id.tvEmptyPlaceholder1)
        val tv2 = viewEmpty.findViewById<TextView>(R.id.tvEmptyPlaceholder2)

        tv1.text = "your bag is empty"
        tv2.text = "items remain in your bag for 1 hour, and then they’re moved to your Saved items"
        iv.setImageResource(R.drawable.ic_surprised)

        if (bag == null){
            checkoutButton.text = "Start shopping"
        }

        checkoutButton.setOnClickListener {
            if (bag == null) {
                activity.changeFragment(HomeFragment())
            }
        }

        return view
    }

}