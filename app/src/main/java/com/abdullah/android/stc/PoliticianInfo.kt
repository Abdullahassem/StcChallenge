package com.abdullah.android.stc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class PoliticianInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_politician_info)
        findViewById<TextView>(R.id.name).text = intent.getStringExtra("name")
        findViewById<TextView>(R.id.department).text = intent.getStringExtra("team")
        findViewById<TextView>(R.id.position).text = intent.getStringExtra("role")
        findViewById<TextView>(R.id.country).text = intent.getStringExtra("country")
        findViewById<TextView>(R.id.city).text = intent.getStringExtra("city")
        findViewById<TextView>(R.id.zip).text = intent.getStringExtra("zip")
        findViewById<TextView>(R.id.address).text = intent.getStringExtra("address")






    }
}