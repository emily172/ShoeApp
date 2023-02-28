package ie.setu.shoeapp.main
import android.app.Application
import ie.setu.shoeapp.models.ShoeMemStore
import ie.setu.shoeapp.models.ShoeModel
//import ie.setu.shoeapp.models.ShoeModel
import timber.log.Timber
import timber.log.Timber.i


class MainApp : Application() {

     //val shoes= ArrayList<ShoeModel>()
    val shoes = ShoeMemStore()


    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("Shoes started")
        // shoes.add(ShoeModel("One", "About one..."))
       //  shoes.add(ShoeModel("Two", "About two..."))
       //  shoes.add(ShoeModel("Three", "About three..."))
    }
}


