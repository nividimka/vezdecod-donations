package com.example.vkdonations


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.create_money_donation_every_month.*
import kotlinx.android.synthetic.main.create_money_donation_one_time1.clPictureLoader
import kotlinx.android.synthetic.main.create_money_donation_one_time1.etPaymentCard
import kotlinx.android.synthetic.main.create_money_donation_one_time1.etPrice
import kotlinx.android.synthetic.main.create_money_donation_one_time1.toolbar


class CreateDonationEveryMonthActivity : Activity() {

//    lateinit var textWacher: TextWatcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_money_donation_every_month)
        clPictureLoader.setOnClickListener {
            Toast.makeText(this, "Заглушка", Toast.LENGTH_LONG).show()
        }
        etPaymentCard.setOnClickListener {
            Toast.makeText(this, "Заглушка", Toast.LENGTH_LONG).show()
        }
        etAuthor.setOnClickListener {
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
            startActivity(Intent(this, CreateDonationFinalActivity::class.java))
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