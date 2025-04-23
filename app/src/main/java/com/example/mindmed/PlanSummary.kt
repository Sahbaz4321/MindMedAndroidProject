package com.example.mindmed

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PlanSummary : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_plan_summary)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
val showPlan=findViewById<TextView>(R.id.showplan)

        val showDate=findViewById<TextView>(R.id.showdate)
        val endtime=findViewById<TextView>(R.id.endDate)

        val planDesc = intent.getStringExtra("planDesc")
        val startDate = intent.getStringExtra("startDate")
        val endDate = intent.getStringExtra("endDate")
        val startTime = intent.getStringExtra("startTime")
        val endTime = intent.getStringExtra("endTime")
        showPlan.text=planDesc
        showDate.text="Start Time :"+startDate+ "/04/2025"+" "+startTime+": 00 AM"
        endtime.text="End Time :"+endDate+ "/04/2025"+" "+endTime+": 00 AM"

    }
}