package com.example.mindmed

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Date
import java.util.Locale

class MoodTracker : AppCompatActivity() {
    private var selectedMood: String = ""
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mood_tracker)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val moodList= listOf(R.id.down,R.id.elated,R.id.neutral,R.id.upset,R.id.coping)

        moodList.forEach{id->
            findViewById<ImageView>(id).setOnClickListener{view->

                    selectedMood = view.tag.toString()
                    Toast.makeText(this, "Mood Selected : $selectedMood", Toast.LENGTH_LONG).show()
                }
        }
        val btn=findViewById<Button>(R.id.moodbutton)
        btn.setOnClickListener{
            val selectedActivity= mutableListOf<String>()
            val checkbox= listOf(R.id.reading,R.id.eating,R.id.hydrating,R.id.sleep,R.id.television,R.id.exercise,R.id.meditation,R.id.socializing)

            checkbox.forEach { id->
                val cb=findViewById<CheckBox>(id)
                if(cb.isChecked) selectedActivity.add(cb.text.toString())
            }

            val selectedWeather=when{
                findViewById<RadioButton>(R.id.radio_sunny).isChecked->"Sunny"
                findViewById<RadioButton>(R.id.radio_rainy).isChecked->"Rainy"
                findViewById<RadioButton>(R.id.radio_cloudy).isChecked->"Cloudy"

                else->"Not Selected"

            }

            val notes=findViewById<EditText>(R.id.entry_notes).text.toString()
            val sdf = SimpleDateFormat("EEEE, dd MMM, yyyy, hh:mm a", Locale.getDefault())
            val currentDateTime = sdf.format(Date())

            val intent=Intent(this,MoodSummaryActivity::class.java)
            intent.putExtra("mood",selectedMood)
            intent.putExtra("weather",selectedWeather)
            intent.putStringArrayListExtra("activities", ArrayList(selectedActivity))
            intent.putExtra("notes",notes)
            intent.putExtra("datetime", currentDateTime)
            startActivity(intent)

        }
    }
}