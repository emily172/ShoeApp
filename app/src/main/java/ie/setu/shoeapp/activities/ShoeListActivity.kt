
package ie.setu.shoeapp.activities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ie.setu.shoeapp.databinding.ActivityShoeListBinding
import ie.setu.shoeapp.databinding.CardShoeBinding
import ie.setu.shoeapp.main.MainApp
import ie.setu.shoeapp.models.ShoeModel

class ShoeListActivity : AppCompatActivity() {

    lateinit var app: MainApp
    private lateinit var binding: ActivityShoeListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoeListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = ShoeAdapter(app.shoes)
    }
}

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
