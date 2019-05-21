package id.gsculerlor.deliveryservice.ui.driver

import androidx.lifecycle.ViewModel
import id.gsculerlor.deliveryservice.network.DataRepository
import id.gsculerlor.deliveryservice.ui.model.Delivery

class DriverViewModel(private val repository: DataRepository) : ViewModel() {
    fun getDelivery(id: Int) = repository.getDelivery(id)
    fun updateDelivery(delivery: Delivery) = repository.updateDelivery(delivery)
    fun updateLocationLog(id: Int, lat: String, long: String) = repository.addLocationLog(id, lat, long)
}
