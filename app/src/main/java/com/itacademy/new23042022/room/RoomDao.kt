package com.itacademy.new23042022.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.itacademy.new23042022.models.inventory

interface RoomDao {

    @Insert
    suspend fun insert(inventory: inventory)

    @Update
    suspend fun update(inventory: inventory)

    @Delete
    suspend fun delete(inventory: inventory)

    @Query("SELECT * FROM inventory")
    suspend fun getAll(): List<inventory>
}