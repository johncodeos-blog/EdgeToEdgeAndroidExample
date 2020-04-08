package com.example.edgetoedgeexample

import android.content.ContentResolver
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_full_screen.*


class FullScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen)

        //Photo Credits: https://unsplash.com/photos/G85VuTpw6jg
        full_screen_photo_view.setImageResource(R.drawable.airplane)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if (isGestureNavigationEnabled(this.contentResolver)) {
                // Extends the PhotoView in the whole screen
                window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
                // Hides StatusBar and Navigation bar, you have to tap to appear
                // window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_IMMERSIVE or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                // Fixes the Full Screen black bar in screen with notch
                window.attributes.layoutInDisplayCutoutMode =
                    WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
            }
        }
    }

    private fun isGestureNavigationEnabled(contentResolver: ContentResolver): Boolean {
        return Settings.Secure.getInt(contentResolver, "navigation_mode", 0) == 2
    }
}


