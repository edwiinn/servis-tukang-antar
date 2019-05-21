package id.gsculerlor.deliveryservice.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.gsculerlor.deliveryservice.ui.model.Delivery
import id.gsculerlor.deliveryservice.ui.model.LocationLog
import id.gsculerlor.deliveryservice.utils.InjectorContainer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataRepository {
    private val dataService by lazy { InjectorContainer.provideRetrofitInstance().create(DataService::class.java) }

    fun getDelivery(id: Int): LiveData<Delivery> {
        val mDelivery = MutableLiveData<Delivery>()

        dataService.getDelivery(id).enqueue(object : Callback<Delivery> {
            override fun onFailure(call: Call<Delivery>, t: Throwable) {
                Log.e("onFailureEnqueue", t.localizedMessage)
            }

            override fun onResponse(call: Call<Delivery>, response: Response<Delivery>) {
                mDelivery.value = response.body()
            }
        })

        return mDelivery
    }

    fun updateDelivery(delivery: Delivery): LiveData<Delivery> {
        val mDelivery = MutableLiveData<Delivery>()

        dataService.updateDelivery(
            delivery.id,
            delivery.orderId,
            delivery.driverId,
            delivery.status,
            delivery.sentAt,
            delivery.arriveAt
        ).enqueue(object : Callback<Delivery> {
            override fun onFailure(call: Call<Delivery>, t: Throwable) {
                Log.e("onFailureEnqueue", t.localizedMessage)
            }

            override fun onResponse(call: Call<Delivery>, response: Response<Delivery>) {
                mDelivery.value = response.body()
            }
        })

        return mDelivery
    }

    fun addLocationLog(deliveryId: Int, lat: String, long: String): LiveData<LocationLog> {
        val mLocationLog = MutableLiveData<LocationLog>()

        dataService.addLocationLog(deliveryId, deliveryId, lat, long).enqueue(object : Callback<LocationLog> {
            override fun onFailure(call: Call<LocationLog>, t: Throwable) {
                Log.e("onFailureEnqueue", t.localizedMessage)
            }

            override fun onResponse(call: Call<LocationLog>, response: Response<LocationLog>) {
                mLocationLog.value = response.body()
            }
        })

        return mLocationLog
    }

    fun getLatestLocationLog(deliveryId: Int): LiveData<LocationLog> {
        val mLocationLog = MutableLiveData<LocationLog>()

        dataService.getLatestLocationLog(deliveryId).enqueue(object : Callback<LocationLog> {
            override fun onFailure(call: Call<LocationLog>, t: Throwable) {
                Log.e("onFailureEnqueue", t.localizedMessage)
            }

            override fun onResponse(call: Call<LocationLog>, response: Response<LocationLog>) {
                mLocationLog.value = response.body()
            }
        })

        return mLocationLog
    }
}