package com.example.vkdonations

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.create_money_donation_one_time2.*
import kotlinx.android.synthetic.main.create_money_donation_one_time2.confirmButton
import kotlinx.android.synthetic.main.create_money_donation_one_time2.etAuthor
import kotlinx.android.synthetic.main.create_money_donation_one_time2.toolbar

class CreateDonationsOneTime2Activity  : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_money_donation_one_time2)

        etEndDate.setOnClickListener {
            Toast.makeText(this,"Заглушка", Toast.LENGTH_LONG).show()
        }
        etAuthor.setOnClickListener {
            Toast.makeText(this,"Заглушка", Toast.LENGTH_LONG).show()
        }
        toolbar.setNavigationOnClickListener {
            finish()
        }
        confirmButton.setOnClickListener {
            startActivity(Intent(this, CreateDonationFinalActivity::class.java))
        }

    }
}