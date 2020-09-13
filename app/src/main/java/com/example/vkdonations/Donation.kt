package com.example.vkdonations

data class Donation(val priceValue: Double)


object DonationHolder {
    var donation: Donation? = null
}