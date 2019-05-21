package id.gsculerlor.deliveryservice.ui.customer

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import id.gsculerlor.deliveryservice.R
import id.gsculerlor.deliveryservice.ui.model.Delivery
import id.gsculerlor.deliveryservice.ui.model.LocationLog
import id.gsculerlor.deliveryservice.utils.InjectorContainer
import kotlinx.android.synthetic.main.customer_fragment.*
import java.text.SimpleDateFormat

class CustomerFragment : Fragment() {

    companion object {
        fun newInstance() = CustomerFragment()
    }

    private lateinit var viewModel: CustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.customer_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =
            ViewModelProviders.of(this, InjectorContainer.provideCustomerViewModel()).get(CustomerViewModel::class.java)
        viewModel.getDelivery(3).observe(this, Observer {
            setupUi(it)
            it.id?.let { id ->
                viewModel.getLatestLocation(id).observe(this, Observer { locationLog ->
                    setupLocation(locationLog)
                })
            }
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
    }

    @SuppressLint("SetTextI18n")
    private fun setupLocation(locationLog: LocationLog) {
        driver_position.text = "${locationLog.driver_lat}, ${locationLog.driver_long}"
    }
}
