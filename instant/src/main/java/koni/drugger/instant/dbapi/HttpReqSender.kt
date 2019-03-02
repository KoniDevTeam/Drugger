package koni.drugger.instant.dbapi

import android.os.AsyncTask
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class HttpReqSender : AsyncTask<String, Void, String>() {

    override fun doInBackground(vararg params: String): String {
        try {
            val urlObj = URL(params[0])
            val con = urlObj.openConnection() as HttpURLConnection

            con.requestMethod = params[1]

            con.setRequestProperty("User-Agent", params[2])

            val in_ = BufferedReader(
                InputStreamReader(con.getInputStream())
            )
            var inputLine: String?
            val response = StringBuilder()
            inputLine = in_.readLine()
            while (inputLine != null) {
                response.append(inputLine)
                inputLine = in_.readLine()
            }
            in_.close()

            return response.toString()
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("TAG", "Error: " + e.toString())
            return "<EXC>"
        }

    }
}