package id.gsculerlor.deliveryservice.ui.customer

import androidx.lifecycle.ViewModel;
import id.gsculerlor.deliveryservice.network.DataRepository

class CustomerViewModel(private val repository: DataRepository) : ViewModel() {
    fun getDelivery(id: Int) = repository.getDelivery(id)
    fun getLatestLocation(id: Int) = repository.getLatestLocationLog(id)
}
