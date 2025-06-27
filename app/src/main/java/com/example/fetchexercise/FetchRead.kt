package com.example.fetchexercise

import android.renderscript.ScriptGroup.Input
import android.util.Log
import java.io.InputStream
import java.net.URL
import java.util.Scanner

class FetchRead : Thread {
    lateinit var activity: MainActivity
    var result : String = ""

    constructor(fromActivity: MainActivity){
        activity = fromActivity
    }

    override fun run() {
        val url : URL = URL(MainActivity.URL_Read)
        val iStream : InputStream = url.openStream()
        val scan : Scanner = Scanner(iStream)

        while(scan.hasNext()){
            result += scan.nextLine()
        }

        val updateGUI: UpdateGui = UpdateGui()
        activity.runOnUiThread(updateGUI)
    }

    inner class UpdateGui : Runnable{
        override fun run() {
            activity.updateViewRead(result)
        }
    }
}