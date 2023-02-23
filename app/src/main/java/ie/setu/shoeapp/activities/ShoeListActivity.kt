package ie.setu.shoeapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ie.setu.shoeapp.R
import ie.setu.shoeapp.main.MainApp

class ShoeListActivity : AppCompatActivity() {

lateinit var app: MainApp

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_shoe_list)
    app = application as MainApp
  }
}