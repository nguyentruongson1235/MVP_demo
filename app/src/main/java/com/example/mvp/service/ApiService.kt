package com.example.mvp.service

import com.example.mvp.utils.Constants
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ApiService {
    fun httpGet(myUrl: String): String {
        val url = URL(myUrl)
        val httpURLConnection = url.openConnection() as HttpURLConnection
        httpURLConnection.apply {
            connectTimeout = Constants.CONNECT_TIME_OUT
            readTimeout = Constants.READ_TIME_OUT
            requestMethod = Constants.METHOD_GET
            connect()
        }

        val bufferedReader = BufferedReader(InputStreamReader(url.openStream()))
        val stringBuilder = StringBuilder()
        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            stringBuilder.append(line)
        }
        bufferedReader.close()
        httpURLConnection.disconnect()
        return stringBuilder.toString()
    }
}
