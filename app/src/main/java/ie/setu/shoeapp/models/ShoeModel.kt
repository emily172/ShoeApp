package ie.setu.shoeapp.models


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShoeModel(var id: Long = 0,
                     var title: String = "",
                     var description: String = "",
                     var price : Double = 0.0,
                     var size : Int = 1,
                     var shoecolor: String = "") : Parcelable









