package ie.setu.shoeapp.models

import timber.log.Timber.i

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class ShoeMemStore : ShoeStore {

    val shoes = ArrayList<ShoeModel>()

    override fun findAll(): List<ShoeModel> {
        return shoes
    }


    override fun create(shoe: ShoeModel) {
        shoe.id = getId()
        shoes.add(shoe)
        logAll()
    }



    override fun update(shoe: ShoeModel) {
        var foundShoe: ShoeModel? = shoes.find { p -> p.id == shoe.id }
        if (foundShoe != null) {
            foundShoe.title = shoe.title
            foundShoe.description = shoe.description
            foundShoe.price = shoe.price
            foundShoe.size = shoe.size
            foundShoe.shoecolor = shoe.shoecolor
            logAll()
        }
    }


    fun logAll() {
        shoes.forEach{ i("$it") }
    }
}
