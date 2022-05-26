package com.itacademy.new23042022.AddActivity

import com.itacademy.new23042022.Repository.MainRepository
import com.itacademy.new23042022.models.inventory

class AddPresenter(private val IAddView: AddActivity): IAddPresenter {

    private val repository = MainRepository()
    override suspend fun inserted(inventory: inventory) {
        repository.insert(inventory)

    }

    override suspend fun updated(inventory: inventory) {
        repository.update(inventory)

    }

}