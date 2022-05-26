package com.itacademy.new23042022.Repository

import com.itacademy.new23042022.models.inventory

interface IMainRepository {
    suspend fun update(inventory: inventory)

    suspend fun  insert(inventory: inventory)

    suspend fun  delete(inventory: inventory)

    suspend fun getAll(): List<inventory>?

}