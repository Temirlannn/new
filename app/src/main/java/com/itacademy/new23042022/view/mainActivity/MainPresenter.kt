package com.itacademy.new23042022.view.mainActivity

import com.itacademy.new23042022.Repository.MainRepository
import com.itacademy.new23042022.models.inventory

class MainPresenter (private val iMainView: IMainView) : IMainPresenter{

    private val repository = MainRepository()
    override suspend fun getAllItems(): List<inventory>? {
        return repository.getAll()
    }

    override suspend fun delete(inventory: inventory) {
        iMainView.showTextDeleted()
        repository.delete(inventory)
    }
}