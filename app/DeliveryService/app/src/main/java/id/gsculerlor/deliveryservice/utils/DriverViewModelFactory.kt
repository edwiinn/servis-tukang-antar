package id.gsculerlor.deliveryservice.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.gsculerlor.deliveryservice.network.DataRepository
import id.gsculerlor.deliveryservice.ui.driver.DriverViewModel

@Suppress("UNCHECKED_CAST")
class DriverViewModelFactory(
    private val repository: DataRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DriverViewModel(repository) as T
    }
}