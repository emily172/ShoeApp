package ie.setu.shoeapp.persistence

import ie.setu.shoeapp.models.ShoeStore

interface Serializer {
    @Throws(Exception::class)
    fun write(obj: Any?)

    @Throws(Exception::class)
    fun read(): Any?


}

