package id.gsculerlor.deliveryservice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.gsculerlor.deliveryservice.ui.driver.DriverFragment
import id.gsculerlor.deliveryservice.ui.customer.CustomerFragment
import kotlinx.android.synthetic.main.include_appbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DriverFragment.newInstance())
                .commitNow()
        }
        setupUi()
    }

    private fun setupUi() {
        toolbar.run {
            inflateMenu(R.menu.menu)
            menu.getItem(0).isChecked = true
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.driver -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.container, DriverFragment.newInstance())
                            .commitNow()

                        true
                    }
                    else -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.container, CustomerFragment.newInstance())
                            .commitNow()

                        true
                    }
                }
            }
        }
    }
}
