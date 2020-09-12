package com.example.vkdonations

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_donations.*

class DonationsActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donations)
        bCreateDonation.setOnClickListener {
            startActivity(Intent(this, NewDonationActivity::class.java))
        }
    }
}