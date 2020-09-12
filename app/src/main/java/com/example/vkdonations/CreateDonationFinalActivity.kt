package com.example.vkdonations

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.create_money_donation_final.*

class CreateDonationFinalActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_money_donation_final)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        toolbar.setOnMenuItemClickListener {
            startActivity(Intent(this, PostsActivity::class.java))
            true
        }
        tvAuthor.setOnClickListener {
            Toast.makeText(this, "Заглушка", Toast.LENGTH_LONG).show()
        }
        etPublication.requestFocus()
        progress.isEnabled = false
        helpButton.isEnabled = false
    }
}