package id.gsculerlor.deliveryservice.ui.driver

import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import id.gsculerlor.deliveryservice.R
import id.gsculerlor.deliveryservice.ui.model.Delivery
import id.gsculerlor.deliveryservice.utils.InjectorContainer
import kotlinx.android.synthetic.main.driver_fragment.*
import java.text.SimpleDateFormat
import java.util.*

class DriverFragment : Fragment() {

    companion object {
        fun newInstance() = DriverFragment()
    }

    private lateinit var viewModel: DriverViewModel
    private lateinit var fusedLocationClient: FusedLocationProviderClient


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.driver_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        viewModel =
            ViewModelProviders.of(this, InjectorContainer.provideDriverViewModel()).get(DriverViewModel::class.java)

        val observedDelivery = viewModel.getDelivery(3)
        observedDelivery.observe(this, Observer {
            setupUi(it)
            updateLocation(it.id as Int)
        })


    }

    private fun setupUi(delivery: Delivery) {
        order_id.text = delivery.orderId.toString()
        driver_id.text = delivery.driverId.toString()
        status.text = delivery.status
        sent_at.text = SimpleDateFormat("MM/dd/yyyy").format(delivery.sentAt)
        if (delivery.arriveAt != null)
            arrived_at.text = SimpleDateFormat("MM/dd/yyyy").format(delivery.arriveAt)
        else
            arrived_at.text = "-"

        update.setOnClickListener {
            updateStatus(delivery)
        }
    }

    private fun updateStatus(delivery: Delivery) {
        val newStatus = when (delivery.status) {
            "Makanan sedang diambil" -> "Makanan sudah diambil"
            "Makanan sudah diambil" -> "Makanan sedang diantar"
            "Makanan sedang diantar" -> "Makanan telah sampai"
            else -> "Tidak diketahui"
        }

        val newDelivery = Delivery(
            delivery.id,
            delivery.orderId,
            delivery.driverId,
            newStatus,
            delivery.sentAt,
            delivery.arriveAt
        )

        viewModel.updateDelivery(newDelivery).observe(this, Observer {
            setupUi(it)
        })
    }

    @SuppressLint("MissingPermission")
    private fun updateLocation(id: Int) {
        val timer = Timer()
        val monitor = object : TimerTask() {
            override fun run() {
                fusedLocationClient.lastLocation
                    .addOnSuccessListener { location: Location? ->
                        viewModel.updateLocationLog(id, location?.latitude.toString(), location?.longitude.toString())
                        Log.d("Location", "${location?.latitude} ${location?.longitude}")
                    }
            }
        }

        timer.schedule(monitor, 1000, 10000)
    }
}
