package com.itacademy.new23042022.Repository

import com.itacademy.new23042022.App
import com.itacademy.new23042022.models.inventory

class MainRepository: IMainRepository{
    val db = App.instance?.getDatabase()
    val dao = db?.dao()

    override suspend fun update(inventory: inventory) {
        dao?.update(inventory)
    }

    override suspend fun insert(inventory: inventory) {
        dao?.insert(inventory)
    }

    override suspend fun delete(inventory: inventory) {
        dao?.delete(inventory)
    }

    override suspend fun getAll(): List<inventory>? {
        return dao?.getAll()
    }

}