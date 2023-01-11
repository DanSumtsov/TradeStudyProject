package com.optiontrade.br

import android.util.Log
import com.google.gson.Gson

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



