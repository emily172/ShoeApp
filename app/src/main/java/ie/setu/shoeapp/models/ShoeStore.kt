package ie.setu.shoeapp.models

import ie.setu.shoeapp.persistence.Serializer

interface ShoeStore {

    fun findAll(): List<ShoeModel>
    fun create(shoe: ShoeModel)
    fun update(shoe: ShoeModel)
}

