package id.gsculerlor.deliveryservice.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.gsculerlor.deliveryservice.network.DataRepository
import id.gsculerlor.deliveryservice.ui.customer.CustomerViewModel

@Suppress("UNCHECKED_CAST")
class CustomerViewModelFactory(
    private val repository: DataRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CustomerViewModel(repository) as T
    }
}