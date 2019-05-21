package id.gsculerlor.deliveryservice.utils

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import java.util.*

class MyLocation {
    lateinit var timer1: Timer
    lateinit var lm: LocationManager
    lateinit var locationResult: LocationResult
    private var isGpsEnabled = false
    private var isNetworkEnabled = false

    internal var locationListenerGps: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            timer1.cancel()
            locationResult.getLocation(location)
            lm.removeUpdates(this)
            lm.removeUpdates(locationListenerNetwork)
        }

        override fun onProviderDisabled(provider: String) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
    }

    internal var locationListenerNetwork: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            timer1.cancel()
            locationResult.getLocation(location)
            lm.removeUpdates(this)
            lm.removeUpdates(locationListenerGps)
        }

        override fun onProviderDisabled(provider: String) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
    }

    @SuppressLint("MissingPermission")
    fun getLocation(context: Context, result: LocationResult): Boolean {
        //I use LocationResult callback class to pass location value from MyLocation to user code.
        locationResult = result

        //exceptions will be thrown if provider is not permitted.
        try {
            isGpsEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER)
        } catch (ex: Exception) {
        }

        try {
            isNetworkEnabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        } catch (ex: Exception) {
        }

        //don't start listeners if no provider is enabled
        if (!isGpsEnabled && !isNetworkEnabled)
            return false

        if (isGpsEnabled)
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, locationListenerGps)
        if (isNetworkEnabled)
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0f, locationListenerNetwork)
        timer1 = Timer()
        timer1.schedule(GetLastLocation(), 10000)
        return true
    }

    internal inner class GetLastLocation : TimerTask() {
        @SuppressLint("MissingPermission")
        override fun run() {
            lm.removeUpdates(locationListenerGps)
            lm.removeUpdates(locationListenerNetwork)

            var netLoc: Location? = null
            var gpsLoc: Location? = null
            if (isGpsEnabled)
                gpsLoc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            if (isNetworkEnabled)
                netLoc = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

            //if there are both values use the latest one
            if (gpsLoc != null && netLoc != null) {
                if (gpsLoc.time > netLoc.time)
                    locationResult.getLocation(gpsLoc)
                else
                    locationResult.getLocation(netLoc)
                return
            }

            if (gpsLoc != null) {
                locationResult.getLocation(gpsLoc)
                return
            }
            if (netLoc != null) {
                locationResult.getLocation(netLoc)
                return
            }
            locationResult.getLocation(null)
        }
    }

    abstract class LocationResult {
        abstract fun getLocation(location: Location?)
    }
}