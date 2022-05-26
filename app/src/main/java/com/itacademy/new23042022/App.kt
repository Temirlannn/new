package com.itacademy.new23042022

import android.app.Application
import androidx.room.Room
import com.itacademy.new23042022.room.AppDatabase

class App: Application() {
    private var database: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .allowMainThreadQueries().build()
    }

    fun getDatabase(): AppDatabase?{
        return database
    }

    companion object{
        var instance: App? = null
    }
}