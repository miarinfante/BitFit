package com.example.bitfit


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface calorieDao {
    @Query("SELECT * FROM food_table")
    fun getAll(): Flow<List<FoodEntity>>

    @Insert
    fun insertAll(foodCal: List<FoodEntity>)

    @Insert
    fun insert(foodCal: FoodEntity)


    @Query("DELETE FROM food_table")
    fun deleteAll()


}
