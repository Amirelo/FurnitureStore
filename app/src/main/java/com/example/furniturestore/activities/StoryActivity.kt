package com.example.furniturestore.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.furniturestore.R
import com.example.furniturestore.adapters.StoryReelAdapter
import com.example.furniturestore.models.StoryReel

class StoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        val rcStoryReels = findViewById<RecyclerView>(R.id.rcStoryReels)

        var item1 : StoryReel = StoryReel(1,"https://images.pexels.com/photos/716107/pexels-photo-716107.jpeg","Assorted commemorative plates","Popular wearables from Dubai, United Arab Emirates")
        var item2 : StoryReel  = StoryReel(2,"https://images.pexels.com/photos/2767689/pexels-photo-2767689.jpeg","Assorted color yarn lot","New batch of yarns from Centurion, GP, South Africa")
        var item3 : StoryReel  = StoryReel(3,"https://images.pexels.com/photos/7147464/pexels-photo-7147464.jpeg","Workshop","Mannequin near sewing machine in workshop")
        var item4 : StoryReel  = StoryReel(4,"https://images.pexels.com/photos/4040586/pexels-photo-4040586.jpeg","Crystals","Composition of rose quartz and geode amethyst arranged in row")

        val reelList = listOf<StoryReel>(item1,item2,item3,item4)

        val reelAdapter: StoryReelAdapter = StoryReelAdapter(reelList)

        rcStoryReels.adapter = reelAdapter

        rcStoryReels.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)


    }
}