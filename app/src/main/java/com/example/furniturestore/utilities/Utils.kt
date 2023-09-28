package com.example.furniturestore.utilities

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import java.net.URL

class Utils {
    fun  getImg(path: String): Bitmap{
        val url = URL(path);
        val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());

        val resizeBmp: Bitmap = Bitmap.createScaledBitmap(bmp, 640, 320, true)


        return resizeBmp;
    }
}