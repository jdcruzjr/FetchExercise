package com.example.fetchexercise

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    lateinit var read : FetchRead

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        read()
    }

    fun read(){
        var read : FetchRead = FetchRead(this)
        read.start()
    }

    fun updateViewRead(s: String){
        try{
            val lv : ListView = findViewById<ListView>( R.id.list)
            val itemList = mutableListOf<FetchItems>()

            val jsonArr : JSONArray = JSONArray(s)
            for(i in 0 until jsonArr.length()){
                val jsonObject = jsonArr.getJSONObject(i)
                val name: String? = if (jsonObject.isNull("name"))
                    null else jsonObject.getString("name")
                var listId : Int = jsonObject.getInt("listId")
                var id : Int = jsonObject.getInt("id")

                Log.w("Debug", "id=$id, listId=$listId, name='$name', isNullOrBlank=${name.isNullOrBlank()}")

                if (!name.isNullOrBlank()){
                    itemList.add(FetchItems(name,listId,id))
                    Log.w("MA", name)
                }
            }

            val sortedData = itemList.sortedWith(compareBy({ it.getListId() }, { it.getName() }))

            for(data in sortedData){
                Log.w("Debug", "name: " + data.getName())
            }

            val listAdapter = FetchItemsAdapter(this, android.R.layout.simple_list_item_1, sortedData)
            lv.adapter = listAdapter



        }catch (je : JSONException){
            Log.w("MainActivity",s)
        }
    }

    companion object {
        const val URL_Read:String = "https://hiring.fetch.com/hiring.json"
    }
}