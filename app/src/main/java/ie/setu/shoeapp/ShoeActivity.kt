package ie.setu.shoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import ie.setu.shoeapp.databinding.ActivityShoeBinding
import timber.log.Timber
import timber.log.Timber.i

class ShoeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShoeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityShoeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())

        i("Shoe Activity started...")

        binding.btnAdd.setOnClickListener() {
            i("add Button Pressed")

            binding.btnAdd.setOnClickListener() {
                val placemarkTitle = binding.shoeTitle.text.toString()
                if (placemarkTitle.isNotEmpty()) {
                    i("add Button Pressed: $placemarkTitle")
                }
                else {
                    Snackbar
                        .make(it,"Please Enter a title", Snackbar.LENGTH_LONG)
                        .show()
                }
            }

        }
    }
}
