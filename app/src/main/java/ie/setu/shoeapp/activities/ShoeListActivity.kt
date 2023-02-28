package ie.setu.shoeapp.activities
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import ie.setu.shoeapp.R
import ie.setu.shoeapp.adapters.ShoeAdapter
import ie.setu.shoeapp.adapters.ShoeListener
import ie.setu.shoeapp.databinding.ActivityShoeListBinding
import ie.setu.shoeapp.main.MainApp
import ie.setu.shoeapp.models.ShoeModel


class ShoeListActivity : AppCompatActivity(), ShoeListener {


    lateinit var app: MainApp
    private lateinit var binding: ActivityShoeListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoeListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)

        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = ShoeAdapter(app.shoes.findAll(), this)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> {
                val launcherIntent = Intent(this, ShoeActivity::class.java)
                getResult.launch(launcherIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onShoeClick(shoe: ShoeModel) {
        val launcherIntent = Intent(this, ShoeActivity::class.java)
        launcherIntent.putExtra("shoe_edit", shoe)
        getClickResult.launch(launcherIntent)
    }
    private val getClickResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                (binding.recyclerView.adapter)?.
                notifyItemRangeChanged(0,app.shoes.findAll().size)
            }
        }

    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                (binding.recyclerView.adapter)?.
                notifyItemRangeChanged(0,app.shoes.findAll().size)
            }
        }
}



