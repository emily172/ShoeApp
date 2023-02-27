package ie.setu.shoeapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import ie.setu.shoeapp.R
import ie.setu.shoeapp.databinding.ActivityShoeBinding
import ie.setu.shoeapp.main.MainApp
import ie.setu.shoeapp.models.ShoeModel
import timber.log.Timber
import timber.log.Timber.i

class ShoeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoeBinding

    var shoe = ShoeModel()
    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)

        app = application as MainApp
        i("Shoe Activity started...")
        binding.btnAdd.setOnClickListener() {

            //add new fields here
            shoe.title = binding.shoeTitle.text.toString()
            shoe.description = binding.description.text.toString()
            shoe.price = binding.price.text.toString().toDouble()
            shoe.size = binding.size.text.toString().toInt()
            shoe.shoecolor = binding.colorSpinner.selectedItem.toString()


            if (shoe.title.isNotEmpty()) {
                app.shoes.add(shoe.copy())
                i("add Button Pressed: ${shoe}")
                for (i in app.shoes.indices) {
                    i("Shoe[$i]:${this.app.shoes[i]}")
                }

            setResult(RESULT_OK)
            finish()
        }
            else {
                Snackbar.make(it,"Please Enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }


        }
        val spinner: Spinner = binding.colorSpinner
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.colors_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_shoe, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_cancel -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }


}


