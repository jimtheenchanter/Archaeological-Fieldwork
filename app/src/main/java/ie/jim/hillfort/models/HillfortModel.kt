package ie.jim.hillfort.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// implement a parcelize capability.
@Parcelize
data class HillfortModel (
    var id: Long = 0,
    var title: String = "",
    var description: String = "",
    var image: String = "",
    var lat : Double = 0.0,
    var lng: Double = 0.0,
//    val visited: Boolean = false,
    var zoom: Float = 0f)
: Parcelable

@Parcelize
data class Location(var lat: Double = 0.0,
                    var lng: Double = 0.0,
                    var zoom: Float = 0f) : Parcelable