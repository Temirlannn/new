package com.itacademy.new23042022.view.mainActivity

import com.itacademy.new23042022.models.inventory

interface IMainPresenter {
    suspend fun getAllItems(): List<inventory>?

    suspend fun  delete(inventory: inventory)

}