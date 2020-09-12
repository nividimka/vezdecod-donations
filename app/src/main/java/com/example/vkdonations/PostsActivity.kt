package com.example.vkdonations

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.posts_activity.*

class PostsActivity : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.posts_activity)
        progress.isEnabled = false
    }
}