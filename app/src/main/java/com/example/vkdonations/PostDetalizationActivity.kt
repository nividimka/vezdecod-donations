package com.example.vkdonations


import android.app.Activity
import android.os.Bundle
import android.view.WindowManager
import androidx.constraintlayout.widget.ConstraintLayout
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
        val params = toolbar.layoutParams as ConstraintLayout.LayoutParams
        params.setMargins(0, getStatusBarHeight(), 0, 0)
        toolbar.layoutParams = params
    }
    fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }
}