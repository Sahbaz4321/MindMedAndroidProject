package com.example.mindmed

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class Quotes_active : AppCompatActivity() {
    data class QuoteItem(
        val imageRes: Int,
        val quote: String,
        val textColor: Int  // use Color.parseColor("#...") or Color.RED etc.
    )

    private val quoteItems = listOf(
        QuoteItem(
            R.drawable.moti1,
            "Believe in yourself and all that you are.",
            Color.parseColor("#000000")  // White
        ),
        QuoteItem(
            R.drawable.moti2,
            "Push yourself, because no one else is going to do it for you.",
            Color.parseColor("#000000")  // Yellow
        ),
        QuoteItem(
            R.drawable.moti3,
            "Your limitation—it’s only your imagination.",
            Color.parseColor("#EFDEC9")  // Cyan
        ),
        QuoteItem(
            R.drawable.moti4,
            "Yesterday is gone. Tomorrow has not yet come. We have only today. Let us begin." ,
//                    Color.parseColor("#FF9800")
        // Orange
                            Color.parseColor("#000000")  // Orange

        )
    )
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes_active)

        val backgroundImage: ImageView = findViewById(R.id.backgroundImage)
        val quoteText: TextView = findViewById(R.id.quoteText)
        val arrowLeft: ImageView = findViewById(R.id.arrow_left)  // Use ImageView for arrow_left
        val arrowRight: ImageView = findViewById(R.id.arrow_right) // Use ImageView for arrow_right

        // Function to show a random quote
        fun showRandomQuote() {
            val randomItem = quoteItems[Random.nextInt(quoteItems.size)]
            backgroundImage.setImageResource(randomItem.imageRes)
            quoteText.text = randomItem.quote
            quoteText.setTextColor(randomItem.textColor)
        }

        // Show one quote initially
        showRandomQuote()

        // Change quote when left arrow is clicked
        arrowLeft.setOnClickListener {
            showRandomQuote()
        }

        // Change quote when right arrow is clicked
        arrowRight.setOnClickListener {
            showRandomQuote()
        }
    }


}
