package id.gsculerlor.deliveryservice.network

import id.gsculerlor.deliveryservice.ui.model.Delivery
import id.gsculerlor.deliveryservice.ui.model.LocationLog
import retrofit2.Call
import retrofit2.http.*

interface DataService {
    @GET("{id}")
    fun getDelivery(@Path("id") id: Int?): Call<Delivery>

    @PUT("{id}")
    @FormUrlEncoded
    fun updateDelivery(
        @Path("id") id: Int?,
        @Field("orderId") orderId: Int?,
        @Field("driverId") driverId: Int?,
        @Field("status") status: String?,
        @Field("sentAt") sentAt: Long?,
        @Field("arrivedAt") arrivedAt: Long?
    ): Call<Delivery>

    @POST("{id}/log")
    @FormUrlEncoded
    fun addLocationLog(
        @Path("id") id: Int?,
        @Field("deliveryId") deliveryId: Int?,
        @Field("driverLat") driverLat: String?,
        @Field("driverLong") driverLong: String?
    ): Call<LocationLog>

    @GET("{id}/log/latest")
    fun getLatestLocationLog(@Path("id") id: Int?): Call<LocationLog>
}