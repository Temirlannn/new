package com.itacademy.new23042022.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.itacademy.new23042022.models.inventory


@Database(entities = [inventory::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun dao(): RoomDao
}
