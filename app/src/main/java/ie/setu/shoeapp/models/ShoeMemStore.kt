package ie.setu.shoeapp.models

class ShoeMemStore : ShoeStore {

    val shoes = ArrayList<ShoeModel>()

    override fun findAll(): List<ShoeModel> {
        return shoes
    }

    override fun create(shoe: ShoeModel) {
        shoes.add(shoe)
    }
}