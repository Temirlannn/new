package com.itacademy.new23042022.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inventory")
data class inventory(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var quantity: Int,
    var categoryName: String,
    var photo: String
)