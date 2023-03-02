package ie.setu.shoeapp.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
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

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)

        app = application as MainApp
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
        i("Shoe Activity started...")
        if (intent.hasExtra("shoe_edit")) {
            shoe = intent.extras?.getParcelable("shoe_edit")!!
            //added in return data once clicked
            binding.shoeTitle.setText(shoe.title)
            binding.description.setText(shoe.description)
            binding.price.setText(shoe.price.toString())
            binding.size.setText(shoe.size.toString())
            //added binding
            binding.btnAdd.setText(getString(R.string.button_editShoe))
            binding.colorSpinner.setSelection(
                resources.getStringArray(R.array.colors_array).indexOf(shoe.shoecolor)
            )

        }

        binding.btnAdd.setOnClickListener() {
            if (binding.shoeTitle.text.toString().isNotEmpty() && binding.price.text.toString()
                    .isNotEmpty()
            ) {
                (binding.shoeTitle.text.toString().isNotEmpty() && binding.shoeTitle.text.toString()
                    .isNotEmpty())
                (binding.shoeTitle.text.toString().isNotEmpty() && binding.size.text.toString()
                    .isNotEmpty())
                (binding.shoeTitle.text.toString()
                    .isNotEmpty() && binding.colorSpinner.selectedItem.toString().isNotEmpty())
                //add new fields here
                shoe.title = binding.shoeTitle.text.toString()
                shoe.description = binding.description.text.toString()
                shoe.price = binding.price.text.toString().toDouble()
                shoe.size = binding.size.text.toString().toInt()
                shoe.shoecolor = binding.colorSpinner.selectedItem.toString()



                if(Environment.isExternalStorageManager())
                {

                }else {
                    val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
                    intent.data = Uri.parse("package" + packageName)
                    startActivity(intent)
                }



                if (intent.hasExtra("shoe_edit"))
                    app.shoes.update(shoe.copy())
                else
                    app.shoes.create(shoe.copy())

                i("add Button Pressed: ${shoe}")
                for (i in app.shoes.findAll().indices) {
                    i("Shoe[$i]:${this.app.shoes.shoes[i]}")
                }

                setResult(RESULT_OK)
                //store()
                finish()
            } else {
                Snackbar
                    .make(it, R.string.enter_shoe_title, Snackbar.LENGTH_LONG)
                    .show()

            }

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


