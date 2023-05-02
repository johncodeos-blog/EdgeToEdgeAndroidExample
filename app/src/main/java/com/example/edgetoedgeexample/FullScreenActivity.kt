package com.example.edgetoedgeexample

import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.github.chrisbanes.photoview.PhotoView


class FullScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen)

        val fullScreenPhotoView = findViewById<PhotoView>(R.id.full_screen_photo_view)

        // Photo Credits: https://unsplash.com/photos/G85VuTpw6jg
        fullScreenPhotoView.setImageResource(R.drawable.airplane)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && isGestureNavigationEnabled()) {
            configureFullScreenMode()
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun configureFullScreenMode() {
        // Extends the PhotoView in the whole screen
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        // Hides StatusBar and Navigation bar, you have to tap to appear
        // window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_IMMERSIVE or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

        // Fixes the Full Screen black bar in screens with notch
        window.attributes.layoutInDisplayCutoutMode =
            WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
    }

    private fun isGestureNavigationEnabled(): Boolean {
        // Default navigation mode value
        val defaultNavigationMode = 0
        val gestureNavigationMode = 2

        return Settings.Secure.getInt(contentResolver, "navigation_mode", defaultNavigationMode) == gestureNavigationMode
    }
}
