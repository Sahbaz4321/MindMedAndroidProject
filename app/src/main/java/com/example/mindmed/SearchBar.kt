package com.example.mindmed

import LanguageAdapter
import LanguageData
import android.annotation.SuppressLint
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
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class SearchBar : AppCompatActivity() {
    private lateinit var searchview:SearchView
    private lateinit var recycleView:RecyclerView
    private var mList = ArrayList<LanguageData>()
    private lateinit var adapter: LanguageAdapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search_bar)
        recycleView=findViewById(R.id.recycleView)
        searchview=findViewById(R.id.searchview)
        recycleView.setHasFixedSize(true)
        recycleView.layoutManager=LinearLayoutManager(this)
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