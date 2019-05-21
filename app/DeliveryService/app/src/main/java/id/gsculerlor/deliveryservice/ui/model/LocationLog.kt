package id.gsculerlor.deliveryservice.ui.model

import com.google.gson.annotations.SerializedName

data class LocationLog(

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("delivery_id")
    val deliveryId: Int? = null,

    @SerializedName("driver_lat")
    val driver_lat: String? = null,

    @SerializedName("driver_long")
    val driver_long: String? = null,

    @SerializedName("timestamp")
    val timestamp: Long? = null
)