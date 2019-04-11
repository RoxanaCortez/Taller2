package com.roxyapps.roxana.taller2.utilies

import android.net.Uri
import android.util.Log
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.*

class NetworkUtils {
    val COIN_API_BASE_URL=""
    val COIN_INFO="country"

    fun buildSearUrl(country: String): URL {
        val builUri = Uri.parse(COIN_API_BASE_URL)
            .buildUpon()
            .appendPath(COIN_INFO)
            .appendPath(country)
            .build()

        return try{
            Log.d("URL", builUri.toString())
            URL(builUri.toString())
        }catch (e: MalformedURLException){
            URL("")
        }
    }
    @Throws(IOException::class)
    fun getResponseFromHttpUrl(url: URL):String{
        val urlConnection = url.openConnection() as HttpURLConnection
        try{
            val `in` = urlConnection.inputStream

            val scanner = Scanner (`in`)

            scanner.useDelimiter("\\A")

            val hasInput = scanner.hasNext()
            return if(hasInput){
                scanner.next()
            }else{
                ""
            }
        }finally {
            urlConnection.disconnect()
        }
    }
}