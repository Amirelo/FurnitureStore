package com.example.furniturestore.utilities

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowManager
import java.net.URL

class Utils {

    fun getScreenSize(context: Context): Array<Int>{
        val displayMetric = DisplayMetrics()
        val windowManager: WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(displayMetric)
        val height = displayMetric.heightPixels
        val width = displayMetric.widthPixels
        return arrayOf(height, width)
    }

    fun getImg(path: String): Bitmap{

        val url = URL(path);
        val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());

        val resizeBmp: Bitmap = Bitmap.createScaledBitmap(bmp, 640, 320, true)


        return resizeBmp;
    }

    fun getImgWithSize(path: String, dimensions: Array<Int>): Bitmap{
        val url = URL(path);
        val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());

        val resizeBmp: Bitmap = Bitmap.createScaledBitmap(bmp, dimensions[0], dimensions[1], true)


        return resizeBmp;
    }
}