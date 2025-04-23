package com.example.mindmed

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class planActivity_desc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_plan_desc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val plan=findViewById<EditText>(R.id.plan_desc)
        val s_time=findViewById<EditText>(R.id.startTime)
        val e_time=findViewById<EditText>(R.id.endTime)
        val s_date=findViewById<EditText>(R.id.startDate)
        val e_date=findViewById<EditText>(R.id.endDate)
        val btn=findViewById<Button>(R.id.savePlan)

        btn.setOnClickListener{
            val planDesc=plan.text.toString()
            val startDate=s_date.text.toString()
            val endDate=e_date.text.toString()
            val startTime=s_time.text.toString()

            val endTime=e_time.text.toString()

            val intent= Intent(this,PlanSummary::class.java)
            intent.putExtra("planDesc", planDesc)
            intent.putExtra("startDate", startDate)
            intent.putExtra("endDate", endDate)
            intent.putExtra("startTime", startTime)
            intent.putExtra("endTime", endTime)

            startActivity(intent)
        }

    }
}