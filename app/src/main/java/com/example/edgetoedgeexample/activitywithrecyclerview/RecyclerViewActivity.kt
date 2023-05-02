package com.example.edgetoedgeexample.activitywithrecyclerview

import android.content.ContentResolver
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.edgetoedgeexample.R


class RecyclerViewActivity : AppCompatActivity() {

    private var itemsArray = ArrayList<String>()
    private lateinit var adapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val recyclerViewContentId = findViewById<RelativeLayout>(R.id.recycler_view_content_id)

        initRecyclerView(recyclerView)
        loadData()
        adapter = RVAdapter(itemsArray)
        recyclerView.adapter = adapter

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && isGestureNavigationEnabled()) {
            extendBackgroundUnderNavigationBar(recyclerView, recyclerViewContentId)
        }
    }

    private fun initRecyclerView(recyclerView: RecyclerView) {
        val llm = LinearLayoutManager(this)
        recyclerView.layoutManager = llm
        recyclerView.setHasFixedSize(true)
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, llm.orientation)
        recyclerView.addItemDecoration(dividerItemDecoration)
    }

    private fun extendBackgroundUnderNavigationBar(
        recyclerView: RecyclerView,
        recyclerViewContentId: RelativeLayout
    ) {
        // Disable clipping of the RecyclerView content when we use padding
        recyclerView.clipToPadding = false

        // Make the Gesture Navigation Bar transparent
        window.navigationBarColor = Color.TRANSPARENT

        // Expand the Views (RecyclerView) under the gesture navigation bar and toolbar
        window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)

        // Set padding for the Views (RecyclerView and Relative Layout) from the System Views (Gesture Navigation Bar, Toolbar)
        recyclerViewContentId.setOnApplyWindowInsetsListener { _, insets ->
            val topPadding = insets.systemWindowInsetTop
            val bottomPadding = insets.systemWindowInsetBottom
            recyclerViewContentId.setPadding(0, topPadding, 0, 0)
            recyclerView.setPadding(0, 0, 0, bottomPadding)
            insets.consumeSystemWindowInsets()
        }
    }

    private fun isGestureNavigationEnabled(): Boolean {
        val defaultNavigationMode = 0
        val gestureNavigationMode = 2

        return Settings.Secure.getInt(contentResolver, "navigation_mode", defaultNavigationMode) == gestureNavigationMode
    }

    private fun loadData() {
        for (i in 0..20) {
            itemsArray.add("Item $i")
        }
    }
}