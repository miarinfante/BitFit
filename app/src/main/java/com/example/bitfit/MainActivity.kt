package com.example.bitfit

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var mItem: List<ClipData.Item>
    lateinit var foodCal: ArrayList<Food>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foodCal = ArrayList()

        foodCal.add(Food("Apple", "70"))
        val foodList = findViewById<RecyclerView>(R.id.food)
        val adapter = FoodAdapter(foodCal)

        foodList.adapter = adapter
        foodList.layoutManager = LinearLayoutManager(this)

        val newEntry = findViewById<Button>(R.id.recordButton)

        newEntry.setOnClickListener {
           val i = Intent(this@MainActivity, DetailActivity::class.java)
          startActivity(i)
        }

    }
}