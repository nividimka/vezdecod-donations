package com.example.vkdonations

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new_donation.*

class NewDonationActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_donation)
        card1.setOnClickListener {
            startActivity(Intent(this, CreateDonationsOneTime1Activity::class.java))
        }
        card2.setOnClickListener {
            startActivity(Intent(this, CreateDonationEveryMonthActivity::class.java))
        }
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}