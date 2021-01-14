package com.abdullah.android.stc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import getJsonDataFromAsset
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val jsonFileString = getJsonDataFromAsset(applicationContext, "us_senators.json")
        Log.i("data", jsonFileString!!)

        val gson = Gson()
        val listPoliticianType = object : TypeToken<List<Politician>>() {}.type
//        val listPoliticianType = object : TypeToken<List<Objects>>() {}.type



        var politicians: List<Politician> = gson.fromJson(jsonFileString, listPoliticianType)
//        var politicians: List<Objects> = gson.fromJson(jsonFileString, listPoliticianType)

        val adapter=PoliticianAdapter(this,politicians)
//        val adapter=PoliticianAdapter(this,politicians[0].objects)

        findViewById<RecyclerView>(R.id.recycler_view).adapter=adapter
        findViewById<RecyclerView>(R.id.recycler_view).layoutManager=LinearLayoutManager(this)







    }
}