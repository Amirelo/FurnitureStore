package com.example.furniturestore.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView.OnItemSelectedListener
import androidx.fragment.app.Fragment
import com.example.furniturestore.fragments.HomeFragment
import com.example.furniturestore.R
import com.example.furniturestore.fragments.BagFragment
import com.example.furniturestore.fragments.FavoriteFragment
import com.example.furniturestore.fragments.account.AccountFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botNav = findViewById<BottomNavigationView>(R.id.botNav)
        var fragment: Fragment = HomeFragment()

        changeFragment(fragment)

        botNav.setOnItemSelectedListener { item ->
            when (item.itemId){
                R.id.navHome -> fragment = HomeFragment()
                R.id.navBag -> fragment = BagFragment()
                R.id.navFavorite -> fragment = FavoriteFragment()
                R.id.navAccount -> fragment = AccountFragment()

            }
            changeFragment(fragment)
            return@setOnItemSelectedListener true

         }

    }

    fun changeFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.flMain, fragment)
            .addToBackStack(null)
            .commit();
    }
}