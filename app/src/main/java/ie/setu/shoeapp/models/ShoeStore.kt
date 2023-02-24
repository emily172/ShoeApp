package ie.setu.shoeapp.models

interface ShoeStore {
fun findAll(): List<ShoeModel>
fun create(shoe: ShoeModel)
}