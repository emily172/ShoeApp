package ie.setu.shoeapp.main
import android.app.Application
import ie.setu.shoeapp.models.ShoeModel
import timber.log.Timber
import timber.log.Timber.i


class MainApp : Application() {
lateinit var shoes:ArrayList<ShoeModel>
    override fun onCreate() {
        super.onCreate()
        shoes = ArrayList<ShoeModel>()
        Timber.plant(Timber.DebugTree())
        i("Shoe started")
    }
}
