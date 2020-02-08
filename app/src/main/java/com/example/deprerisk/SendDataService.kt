package com.example.deprerisk

import android.os.AsyncTask
import java.io.PrintWriter
import java.net.Socket


class SendDataService : AsyncTask<String, Unit, Unit>() {
    override fun doInBackground(vararg params: String) {
        try {
            val message = params[0]
            val socket = Socket(SERVER_ADDRESS, PORT)
            val printWriter = PrintWriter(socket.getOutputStream())
            printWriter.write(message)
            printWriter.flush()
            printWriter.close()
            socket.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        const val SERVER_ADDRESS = "192.168.1.59"
        const val PORT = 4000
    }
}

