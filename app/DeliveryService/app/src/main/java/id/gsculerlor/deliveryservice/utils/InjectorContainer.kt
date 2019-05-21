package id.gsculerlor.deliveryservice.utils

import id.gsculerlor.deliveryservice.network.DataRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InjectorContainer {
    private const val API_URL = "http://delivery.eastus.cloudapp.azure.com/delivery/"
    private val repository = DataRepository()

    fun provideDriverViewModel(): DriverViewModelFactory {
        return DriverViewModelFactory(repository)
    }

    fun provideCustomerViewModel(): CustomerViewModelFactory {
        return CustomerViewModelFactory(repository)
    }

    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}