package com.example.mindmed

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import java.util.Locale
import LanguageAdapter
import LanguageData
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class HomeIcon : AppCompatActivity() {
    private lateinit var searchview:SearchView
    private lateinit var recycleView:RecyclerView
    private var mList = ArrayList<LanguageData>()
    private lateinit var adapter: LanguageAdapter
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_icon)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val plan=findViewById<LinearLayout>(R.id.plan_home)
        plan.setOnClickListener{
            val intent= Intent(this,planActivity_desc::class.java)
            startActivity(intent)
        }

        val mood=findViewById<LinearLayout>(R.id.mood_tracker)
        mood.setOnClickListener{
            val intent=Intent(this,MoodTracker::class.java)
            startActivity(intent)
        }

        val quotes=findViewById<LinearLayout>(R.id.motivation_qotes)
        quotes.setOnClickListener{
            val intent=Intent(this,Quotes_active::class.java)
            startActivity(intent)
        }

        val rem=findViewById<LinearLayout>(R.id.remainder)
        rem.setOnClickListener{
            val intent=Intent(this,TrackMealReminder::class.java)
            startActivity(intent)
        }

        val call=findViewById<LinearLayout>(R.id.call)
        call.setOnClickListener{
            val intent=Intent(this,Emergency::class.java)
            startActivity(intent)
        }

        val menuIcon = findViewById<ImageView>(R.id.menu)
        menuIcon.setOnClickListener { view ->
            val popupMenu = androidx.appcompat.widget.PopupMenu(this, view)
            popupMenu.menuInflater.inflate(R.menu.itemmenu, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu_profile -> {
                        Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.menu_contact -> {
                        Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.menu_logout -> {
                        Toast.makeText(this, "Logout clicked", Toast.LENGTH_SHORT).show()
                        val intent=Intent(this,login::class.java)
                        startActivity(intent)
                        true
                    }
                    else -> false
                }
            }
            popupMenu.show()
        }






        recycleView=findViewById(R.id.recycleView)
        searchview=findViewById(R.id.searchview)
        recycleView.setHasFixedSize(true)
        recycleView.layoutManager= LinearLayoutManager(this)
        addDataToList();
        adapter = LanguageAdapter(mList)
        recycleView.adapter = adapter

        searchview.setOnQueryTextFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                recycleView.visibility = View.VISIBLE
            } else {
                recycleView.visibility = View.GONE
            }
        }

        searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
    }



    // Handle menu item click

    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<LanguageData>()
            for (i in mList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }
    private fun addDataToList(){

        mList.add(LanguageData("Java"))
        mList.add(LanguageData("Kotlin"))
        mList.add(LanguageData("C++"))
        mList.add(LanguageData("Python"))
        mList.add(LanguageData("HTML"))
        mList.add(LanguageData("Swift"))
        mList.add(LanguageData("C#"))
        mList.add(LanguageData("JavaScript"))
    }

}