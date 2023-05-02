package com.example.edgetoedgeexample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.edgetoedgeexample.activitywithrecyclerview.RecyclerViewActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerViewBtn = findViewById<Button>(R.id.recyclerview_btn)
        val fullScreenBtn = findViewById<Button>(R.id.full_screen_btn)

        recyclerViewBtn.setOnClickListener {
            val intent = Intent(baseContext, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        fullScreenBtn.setOnClickListener {
            val intent = Intent(baseContext, FullScreenActivity::class.java)
            startActivity(intent)
        }
    }
}
