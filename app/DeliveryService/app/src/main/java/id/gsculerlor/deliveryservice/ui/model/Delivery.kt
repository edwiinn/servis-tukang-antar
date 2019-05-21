package id.gsculerlor.deliveryservice.ui.model

import com.google.gson.annotations.SerializedName

data class Delivery(

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("order_id")
    val orderId: Int? = null,

    @SerializedName("driver_id")
    val driverId: Int? = null,

    @SerializedName("status")
    val status: String? = null,

    @SerializedName("sent_at")
    val sentAt: Long? = null,

    @SerializedName("arrive_at")
    val arriveAt: Long? = null
)