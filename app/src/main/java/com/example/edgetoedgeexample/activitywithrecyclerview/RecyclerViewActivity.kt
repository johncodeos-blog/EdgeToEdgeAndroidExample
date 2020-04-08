package com.example.edgetoedgeexample.activitywithrecyclerview

import android.content.ContentResolver
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.edgetoedgeexample.R
import kotlinx.android.synthetic.main.activity_recycler_view.*


class RecyclerViewActivity : AppCompatActivity() {

    var itemsArray = ArrayList<String>()
    lateinit var adapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        // Setting layout and divider for the RecyclerView
        val llm = LinearLayoutManager(this)
        recycler_view.layoutManager = llm
        recycler_view.setHasFixedSize(true)
        val dividerItemDecoration = DividerItemDecoration(recycler_view.context, llm.orientation)
        recycler_view.addItemDecoration(dividerItemDecoration)

        // Get the data and update the RecyclerView
        loadData()
        adapter = RVAdapter(itemsArray)
        recycler_view.adapter = adapter


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if (isGestureNavigationEnabled(this.contentResolver)) {
                // Disable clipping of the RecyclerView content when we use padding
                recycler_view.clipToPadding = false

                // Make the Gesture Navigation Bar transparent
                window.navigationBarColor = Color.TRANSPARENT

                // Expand the Views (RecyclerView) under the gesture navigation bar and toolbar
                window.decorView.systemUiVisibility =
                    (View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)

                // Set padding for the Views (RecyclerView and Relative Layout) from the System Views (Gesture Navigation Bar, Toolbar)
                recycler_view_content_id.setOnApplyWindowInsetsListener { v, insets ->
                    val topPadding = insets.systemWindowInsetTop
                    val bottomPadding = insets.systemWindowInsetBottom
                    recycler_view_content_id.setPadding(0, topPadding, 0, 0)
                    recycler_view.setPadding(0, 0, 0, bottomPadding)
                    insets.consumeSystemWindowInsets()
                }
            }
        }
    }

    private fun isGestureNavigationEnabled(contentResolver: ContentResolver): Boolean {
        return Settings.Secure.getInt(contentResolver, "navigation_mode", 0) == 2
    }


    private fun loadData() {
        for (i in 0..20) {
            itemsArray.add("Item $i")
        }
    }
}