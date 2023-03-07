package ie.setu.shoeapp.models


import android.net.Uri
import android.net.Uri.EMPTY
import android.os.Parcelable
import androidx.core.net.toUri
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShoeModel(
    var id: Long = 0,
    var title: String = "",
    var description: String = "",
    var price: Double = 0.0,
    var size: Int = 1,
    var shoecolor: String = "",
    //added image Uri reference
    var image: String ="content://com.android.providers.media.documents/document/image%3A1000000005") : Parcelable











