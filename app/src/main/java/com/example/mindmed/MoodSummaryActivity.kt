package com.example.mindmed

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MoodSummaryActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mood_summary)
        val mood = intent.getStringExtra("mood")
        val activities = intent.getStringExtra("activities")
        val weather = intent.getStringExtra("weather")
        val notes = intent.getStringExtra("notes")
        val datetime = intent.getStringExtra("datetime")

        val moodIcon = findViewById<ImageView>(R.id.mood_icon)
        val dateText = findViewById<TextView>(R.id.date_time)
        val actText = findViewById<TextView>(R.id.activities)
        val weatherText = findViewById<TextView>(R.id.weather)
        val notesText = findViewById<TextView>(R.id.notes)

        // Set mood icon based on mood string
        val moodRes = when (mood) {
            "upset" -> R.drawable.upset
            "down" -> R.drawable.down
            "neutral" -> R.drawable.neutral
            "coping" -> R.drawable.coping
            "elated" -> R.drawable.elated
            else -> R.drawable.neutral
        }

        moodIcon.setImageResource(moodRes)
        dateText.text = datetime
        actText.text = "Recent Activities:  $activities"
        weatherText.text = "Weather:  $weather"
        notesText.text = "Notes:  $notes"



    }


}