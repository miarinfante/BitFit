package com.example.bitfit

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "food")
data class Food(
    @ColumnInfo(name = "foodName") val foodName: String,
    @ColumnInfo(name = "calories") val calories: String,
    @PrimaryKey(autoGenerate = true) val id: Long = 0,

    )