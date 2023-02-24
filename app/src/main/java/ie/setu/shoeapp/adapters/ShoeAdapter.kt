package ie.setu.shoeapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ie.setu.shoeapp.databinding.CardShoeBinding
import ie.setu.shoeapp.models.ShoeModel

class ShoeAdapter constructor(private var shoes: List<ShoeModel>) :
        RecyclerView.Adapter<ShoeAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardShoeBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val shoe = shoes[holder.adapterPosition]
        holder.bind(shoe)
    }

    override fun getItemCount(): Int = shoes.size

    class MainHolder(private val binding : CardShoeBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun bind(shoe: ShoeModel) {
            binding.shoeTitle.text = shoe.title
            binding.description.text = shoe.description
        }
    }
}