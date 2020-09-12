package com.example.vkdonations


import android.app.Activity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.post_detalization_activity.*


class PostDetalizationActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContentView(R.layout.post_detalization_activity)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}