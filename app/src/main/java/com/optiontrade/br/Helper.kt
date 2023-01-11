package com.optiontrade.br

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.util.Patterns
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.children
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream

private const val LOGTAG = "OptionTradeBR_LOG"

fun log(message: String) {
    Log.d(LOGTAG, message)
}

fun toJson(data: Any): String {
    return Gson().toJson(data)
}

fun <T> fromJson(json: String, type: Class<T>): T {
    return Gson().fromJson(json, type)
}

fun ImageView.setImageAssets(context: Context, imgPath: String) {
    try {
        val ims: InputStream = context.assets.open(imgPath)
        this.setImageDrawable(Drawable.createFromStream(ims, null))
    } catch (ex: IOException) {
        log("catch")
        this.setImageDrawable(null)
    }
}

fun changeVisibility(v1: View, v2: View) {
    v2.visibility = v1.visibility
    if (v1.visibility == View.VISIBLE) {
        v1.visibility = View.GONE
    } else {
        v1.visibility = View.VISIBLE
    }
}


fun CharSequence?.isValidEmail() =
    !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()


fun toast(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}

fun timeToString(millis: Long): String {
    var seconds = "${((millis / 1000).toInt() % 60)}"
    var minutes = "${(millis / (1000 * 60) % 60)}"
    var hours = "${(millis / (1000 * 60 * 60))}"
    if (((millis / 1000).toInt() % 60) < 10)
        seconds = "0$seconds"
    if ((millis / (1000 * 60) % 60) < 10)
        minutes = "0$minutes"
    if ((millis / (1000 * 60 * 60)) < 10)
        hours = "0$hours"
    return "$minutes:$seconds"
}


