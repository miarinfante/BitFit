package com.example.bitfit

import android.content.ClipData
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class DetailActivity: AppCompatActivity() {

    lateinit var mItem: List<ClipData.Item>
    lateinit var foodCal: ArrayList<Food>


    override fun onCreate(savedInstanceState: Bundle?){

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val recordBtn = findViewById<Button>(R.id.recordButton)

        foodCal = ArrayList()

        recordBtn.setOnClickListener{
            val foodName = findViewById<EditText>(R.id.foodName).text.toString()
            val calories =  findViewById<EditText>(R.id.calorieNum).text.toString()

            foodCal.add(Food(foodName, calories))


            lifecycleScope.launch(IO){
                lifecycleScope.launch(IO){
                    (application as MyApplication).db.calorieDao().insert(
                        FoodEntity(foodName, calories)
                    )
                }


            }

            val foodList = findViewById<RecyclerView>(R.id.food)

            val adapter = FoodAdapter(foodCal)





        }


    }


}