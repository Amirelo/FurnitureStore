package com.example.furniturestore.activities

import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.furniturestore.R
import com.example.furniturestore.adapters.StoryReelAdapter
import com.example.furniturestore.adapters.TimeLineAdapter
import com.example.furniturestore.models.StoryReel
import java.lang.IllegalStateException
import java.lang.Math.abs

class StoryActivity : AppCompatActivity() {
    var threadRun = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        var position = 0


        val rcStoryReels = findViewById<RecyclerView>(R.id.rcStoryReels)
        val rcTimeLines = findViewById<RecyclerView>(R.id.rcTimeLines)

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

        val reelList = listOf<StoryReel>(item1, item2, item3, item4)
        val reelSize = reelList.size

        val reelAdapter = StoryReelAdapter(reelList, applicationContext)
        var timeLineAdapter = TimeLineAdapter(reelSize, applicationContext, 0)

        rcStoryReels.adapter = reelAdapter
        rcTimeLines.adapter = timeLineAdapter

        rcStoryReels.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        rcTimeLines.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)

        val handler = Handler()
        val thread = Thread(Runnable {
            while (true) {
                handler.postDelayed(Runnable {
                    if (threadRun){
                        position++
                        if (position > reelSize - 1) {
                            position = 0
                        }
                        if (position < 0) {
                            position = reelSize - 1
                        }
                        rcStoryReels.smoothScrollToPosition(position)
                        timeLineAdapter = TimeLineAdapter(reelSize, applicationContext, position)
                        rcTimeLines.adapter = timeLineAdapter
                    } else{
                        threadRun = true
                    }

                }, 5000)
                SystemClock.sleep(5000)
            }

        })

        rcStoryReels.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {

            val gestureDetector = GestureDetector(
                applicationContext,
                object : GestureDetector.SimpleOnGestureListener() {
                    override fun onFling(
                        e1: MotionEvent,
                        e2: MotionEvent,
                        velocityX: Float,
                        velocityY: Float
                    ): Boolean {
                        try {
                            val swipeThreshold = 100
                            val difX = e2.x - e1.x
                            val difY = e2.y - e1.y
                            if (abs(difX) > abs(difY)) {
                                if (abs(difX) > swipeThreshold && abs(velocityY) > swipeThreshold) {
                                    if (difX < 0) {
                                        position++
                                        Toast.makeText(
                                            applicationContext,
                                            "LTR",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        position--
                                        Toast.makeText(
                                            applicationContext,
                                            "RTL",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                        return true
                    }

                    override fun onSingleTapUp(e: MotionEvent): Boolean {
                        return false
                    }
                })

            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                threadRun = false
                var child = rv.findChildViewUnder(e.x, e.y)
                if (child != null && gestureDetector.onTouchEvent(e)) {
                    Toast.makeText(applicationContext, position.toString(), Toast.LENGTH_SHORT)
                        .show()
                    if (position > reelSize - 1) {
                        position = 0
                    }
                    if (position < 0) {
                        position = reelSize - 1
                    }
                    rv.smoothScrollToPosition(position)
                    timeLineAdapter = TimeLineAdapter(reelSize, applicationContext, position)
                    rcTimeLines.adapter = timeLineAdapter
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



        thread.start()
    }
}