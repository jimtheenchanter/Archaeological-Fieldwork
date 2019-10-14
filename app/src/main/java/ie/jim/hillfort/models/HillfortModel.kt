package ie.jim.hillfort.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// implement a parcelize capability.
@Parcelize
data class HillfortModel (
    var id: Long = 0,
    var title: String = "",
    var description: String = "",
    var image: String = ""
): Parcelable