package com.example.vkdonations

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.create_money_donation_one_time1.*


class CreateDonationsOneTime1Activity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_money_donation_one_time1)
        clPictureLoader.setOnClickListener {
            Toast.makeText(this, "Заглушка", Toast.LENGTH_LONG).show()
        }
        etPaymentCard.setOnClickListener {
            Toast.makeText(this, "Заглушка", Toast.LENGTH_LONG).show()
        }
        toolbar.setNavigationOnClickListener {
            finish()
        }
        etPrice.addTextChangedListener(NumberTextWatcherForThousand(etPrice))
        confirmButton.setOnClickListener {
            startActivity(Intent(this, CreateDonationsOneTime2Activity::class.java))
        }

    }
}