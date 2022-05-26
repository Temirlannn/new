package com.itacademy.new23042022.AddActivity

import com.itacademy.new23042022.models.inventory

interface IAddPresenter {
    suspend fun inserted(inventory: inventory)
    suspend fun updated(inventory: inventory)
}