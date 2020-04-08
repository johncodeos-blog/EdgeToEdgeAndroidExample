package com.example.edgetoedgeexample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.edgetoedgeexample.activitywithrecyclerview.RecyclerViewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview_btn.setOnClickListener {
            val intent = Intent(baseContext, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        full_screen_btn.setOnClickListener {
            val intent = Intent(baseContext, FullScreenActivity::class.java)
            startActivity(intent)
        }
    }
}
