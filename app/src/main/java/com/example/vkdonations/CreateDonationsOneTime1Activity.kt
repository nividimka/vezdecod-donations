package com.example.vkdonations

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.create_money_donation_every_month.*
import kotlinx.android.synthetic.main.create_money_donation_one_time1.*
import kotlinx.android.synthetic.main.create_money_donation_one_time1.clPictureLoader
import kotlinx.android.synthetic.main.create_money_donation_one_time1.confirmButton
import kotlinx.android.synthetic.main.create_money_donation_one_time1.etPaymentCard
import kotlinx.android.synthetic.main.create_money_donation_one_time1.etPrice
import kotlinx.android.synthetic.main.create_money_donation_one_time1.toolbar


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
        etPrice.addTextChangedListener(afterTextChanged = {
            checkValidation()
        })

        confirmButton.setOnClickListener {
            DonationHolder.donation = Donation(
                priceValue = etPrice.text.toString()
                    .replace(" ", "")
                    .replace("₽", "").toDouble()
            )
            startActivity(Intent(this, CreateDonationsOneTime2Activity::class.java))
        }
        checkValidation()

    }


    private fun checkValidation() {
        if (etPrice.text.toString()
                .replace(" ", "")
                .replace("₽", "").isEmpty()
        ) {
            confirmButton.isEnabled = false
            return
        }

        confirmButton.isEnabled = true
    }
}