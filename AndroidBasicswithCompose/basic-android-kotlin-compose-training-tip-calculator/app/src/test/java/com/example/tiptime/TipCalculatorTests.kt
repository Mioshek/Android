package com.example.tiptime

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {
    @Test
    fun calculate_20_percent_tip_no_roundup(){
        val amount = 10.00
        val tipPercent = 20.00
        val expected = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(10.00, 20.00, false)

        assertEquals(expected, actualTip)
    }
}