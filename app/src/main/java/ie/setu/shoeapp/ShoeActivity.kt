package ie.setu.shoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber


class ShoeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoe)

        Timber.plant(Timber.DebugTree())
        Timber.i("Shoe Activity started..")

    }
}