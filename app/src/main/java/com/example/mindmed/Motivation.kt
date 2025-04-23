package com.example.yourapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mindmed.R
import kotlin.random.Random

class Motivation : AppCompatActivity() {

    // Pair of image resource ID and corresponding quote
    private val quotes = listOf(
        R.drawable.nature to "Believe in yourself!",
        R.drawable.mountain to "Every moment is a fresh beginning.",
        R.drawable.bird to "Stay positive, work hard, make it happen.",
        R.drawable.desert to "Dream big and dare to fail.",
        R.drawable.download to "Turn your wounds into wisdom."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motivation)

        val quoteImage = findViewById<ImageView>(R.id.quoteImage)
        val quoteText = findViewById<TextView>(R.id.quoteText)

        // Pick a random quote-image pair
        val (imageRes, quote) = quotes[Random.nextInt(quotes.size)]

        // Set to views
        quoteImage.setImageResource(imageRes)
        quoteText.text = quote
    }
}
