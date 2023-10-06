package com.example.furniturestore.utilities

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.DisplayMetrics
import android.view.WindowManager
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.URL
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

class Utils {

    fun getScreenSize(context: Context): Array<Int>{
        val displayMetric = DisplayMetrics()
        val windowManager: WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(displayMetric)
        val height = displayMetric.heightPixels
        val width = displayMetric.widthPixels
        return arrayOf(width, height)
    }

    fun getImgScaled(path: String, type: String): Bitmap{
        var width = 500
        var height = 500
        when (type){
            "ICON" ->  {
                width = 80
                height = 80
            }
        }
        val url = URL("$path?auto=compress&cs=tinysrgb&w=$width&h=$height&dpr=1");
        val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());

        return bmp;
    }

    fun getImg(path: String): Bitmap{

        val url = URL(path);
        val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());

        return bmp;
    }

    fun getImgWithSize(path: String, width: Int, height: Int): Bitmap{
        val url = URL("$path?auto=compress&cs=tinysrgb&w=$width&h=$height&dpr=1");
        val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());



        return bmp;
    }

    fun currencyFormat (language: String, country: String, amount: Double?) : String{
        val currencyFormat = NumberFormat.getCurrencyInstance(Locale(language,country))

        return currencyFormat.format(amount)
    }

    fun loadJSONFromAsset(fileName: String,context: Context): String{
        try {
            val file = context.assets.open(fileName);
            var bufferReader = BufferedReader(InputStreamReader(file))
            val stringBuilder = StringBuilder()

            bufferReader.useLines { lines ->
                lines.forEach {
                    stringBuilder.append(it)
                }
            }
            val jsonstring = stringBuilder.toString()
            return jsonstring
        } catch (e:Exception){
            e.printStackTrace()
        }
        return ""
    }
}