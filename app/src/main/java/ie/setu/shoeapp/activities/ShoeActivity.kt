package ie.setu.shoeapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import ie.setu.shoeapp.databinding.ActivityShoeBinding
import ie.setu.shoeapp.models.ShoeModel
import timber.log.Timber
import timber.log.Timber.i

class ShoeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShoeBinding
    var shoe = ShoeModel()
    val shoes = ArrayList<ShoeModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.plant(Timber.DebugTree())
        i("Shoe Activity started...")

        binding.btnAdd.setOnClickListener() {
            shoe.title = binding.shoeTitle.text.toString()
            if (shoe.title.isNotEmpty()) {
                shoes.add(shoe.copy())
                i("add Button Pressed: ${shoe}")
                for (i in shoes.indices)
                { i("Shoe[$i]:${this.shoes[i]}") }
            }
            else {
                Snackbar.make(it,"Please Enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }
        }

    }
}

