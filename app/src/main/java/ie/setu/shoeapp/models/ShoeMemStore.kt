package ie.setu.shoeapp.models

import ie.setu.shoeapp.persistence.JSONSerializer
import ie.setu.shoeapp.persistence.Serializer
import timber.log.Timber.i
import java.io.File

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class ShoeMemStore : ShoeStore {
    private var serializer: Serializer = JSONSerializer(File("shoes4.xml"))
    var shoes = ArrayList<ShoeModel>()

    override fun findAll(): List<ShoeModel> {
        return shoes
    }


    override fun create(shoe: ShoeModel) {
        shoe.id = getId()
        shoes.add(shoe)
        logAll()
        store()

    }

/*
    override fun update(shoe: ShoeModel) {
        var foundShoe: ShoeModel? = shoes.find { p -> p.id == shoe.id }
        if (foundShoe != null) {
            foundShoe.title = shoe.title
            foundShoe.description = shoe.description
            foundShoe.price = shoe.price
            foundShoe.size = shoe.size
            foundShoe.shoecolor = shoe.shoecolor
            foundShoe.image=shoe.image
             logAll()
             store()


       */
            override fun update(shoe: ShoeModel) {
                var foundShoe: ShoeModel? = shoes.find { p -> p.id == shoe.id }
                if (foundShoe != null) {
                    foundShoe.title = shoe.title
                    foundShoe.description = shoe.description
                    foundShoe.price = shoe.price
                    foundShoe.size = shoe.size
                    foundShoe.shoecolor = shoe.shoecolor
                    //added image update to store
                    foundShoe.image = shoe.image
                    logAll()
                    store()

        }
    }


    fun logAll() {
        shoes.forEach { i("$it") }
    }


    @Throws(Exception::class)
    fun load() {
        shoes = serializer.read() as ArrayList<ShoeModel>
        i("LOAD")
        logAll()
        lastId = shoes.maxOf {it.id }+1
    }

    @Throws(Exception::class)
    fun store() {
        serializer.write(shoes)
    }

}
