package com.example.vkdonations

import android.app.Activity
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
            Toast.makeText(this, "NEXT", Toast.LENGTH_LONG).show()
            true
        }
        tvAuthor.setOnClickListener {
            Toast.makeText(this, "Заглушка", Toast.LENGTH_LONG).show()
        }
        etPublication.requestFocus()
    }
}