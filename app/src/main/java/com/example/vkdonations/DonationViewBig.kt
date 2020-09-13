package com.example.vkdonations

import android.content.Context
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import kotlinx.android.synthetic.main.donation_view_big.view.*
import java.lang.StringBuilder
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

class DonationViewBig @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    var maxDonations: Double = 10000.0
    var currentDonations: Double = 100.0
        set(value) {
            field = value
            setCurrentDonationsInternal(value)
        }
    val currentTextPaint: Paint
    val maxTextPaint: Paint

    init {
        inflate(context, R.layout.donation_view_big, this)
        currentTextPaint = currentPriceProgress.paint
        maxTextPaint = maxTextProgress.paint
    }

    fun setCurrentDonationsInternal(value: Double) {
        drawCurrentProgress()
        drawCurrentText()
        drawMaxText()
    }

    private fun drawMaxText() {
        val currentProgressWidth = (width * currentDonations / maxDonations)
        val text = getFormattedPrice(maxDonations)
        val bounds = Rect()
        currentTextPaint.getTextBounds(text, 0, text.length, bounds)
        val currentWidth = bounds.width()
        if (currentWidth <= ((width - currentProgressWidth) - maxTextProgress.marginEnd - maxTextProgress.marginStart)) {
            maxTextProgress.text = text
            maxTextProgress.visibility = View.VISIBLE
            maxTextProgressOutside.visibility = View.GONE
        } else {
            maxTextProgressOutside.text = text
            maxTextProgress.visibility = View.GONE
            maxTextProgressOutside.visibility = View.VISIBLE
        }
    }

    private fun drawCurrentText() {
        val currentProgressWidth = (width * currentDonations / maxDonations)
        val text = getFormattedPrice(currentDonations)
        val maxText = getFormattedPrice(maxDonations)
        val bounds = Rect()
        currentTextPaint.getTextBounds(maxText, 0, maxText.length, bounds)
        val width = bounds.width()
        if (width <= (currentProgressWidth - currentPriceProgress.marginEnd - currentPriceProgress.marginStart)) {
            currentPriceProgress.text = text
            currentPriceProgress.visibility = View.VISIBLE
            currentPriceOutsideProgress.visibility = View.GONE
        } else {
            currentPriceOutsideProgress.text = text
            currentPriceProgress.visibility = View.GONE
            currentPriceOutsideProgress.visibility = View.VISIBLE
        }
    }

    private fun drawCurrentProgress() {
        val currentProgressWidth = (width * currentDonations / maxDonations)
        val params = progressActive.layoutParams as ConstraintLayout.LayoutParams
        params.width = currentProgressWidth.toInt()
        progressActive.layoutParams = params
    }


    private fun getFormattedPrice(balance: Double?): String {
        val builder = StringBuilder()
        if (balance == null) {
            return ""
        }
        val decimalSymbols = DecimalFormatSymbols(Locale.getDefault())
        decimalSymbols.decimalSeparator = '.'
        decimalSymbols.groupingSeparator = ' '
        val decimalFormat = DecimalFormat("###,##0", decimalSymbols)
        builder.append(decimalFormat.format(balance))
        builder.append(" ₽")
        return builder.toString()
    }
}