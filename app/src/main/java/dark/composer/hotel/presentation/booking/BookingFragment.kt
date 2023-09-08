package dark.composer.hotel.presentation.booking

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import dark.composer.hotel.App
import dark.composer.hotel.R
import dark.composer.hotel.common.BaseFragment
import dark.composer.hotel.databinding.FragmentBookingBinding
import dark.composer.hotel.presentation.booking.adapter.AdapterAdditional
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class BookingFragment : BaseFragment<FragmentBookingBinding>(FragmentBookingBinding::inflate) {
    private val adapter by lazy {
        AdapterAdditional()
    }

    @Inject
    lateinit var viewModel: BookingViewModel

    override fun onViewCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        binding.rv.adapter = adapter

        val list = listOf(
            "Первый турист",
            "Второй турист",
            "Tретий турист",
            "Четвертый турист",
            "Пятый турист",
            "Шестой турист",
            "Седьмой турист",
            "Восьмой турист",
            "Девятый турист",
            "Десятый турист",
        )

        var pos = 0

        binding.add.setOnClickListener {
            adapter.addItem(list[pos])
            pos++
        }

        binding.back.setOnClickListener {
            navController.popBackStack()
        }

        binding.next.setOnClickListener {
            navController.navigate(R.id.action_bookingFragment_to_successFragment)
        }

        getBookingData()

        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        binding.email.addTextChangedListener {
            it?.let {
                if (it.toString().trim().matches(emailPattern.toRegex()) && it.isNotEmpty()) {
                    Log.d("sdfdfsfsdf", "onViewCreate: true")
                    binding.emailInput.helperText = "Введенo неправильно"
                } else {
                    Log.d("sdfdfsfsdf", "onViewCreate:  false")
                    binding.emailInput.isHelperTextEnabled = false
                }
            }
        }
    }

    private fun getBookingData() = lifecycleScope.launch {
        viewModel.getBookingData().collectLatest {
            it.data?.let { data ->
                binding.apply {
                    val total = data.tour_price + data.fuel_charge + data.service_charge

                    rating.text =
                        getString(R.string.rating, data.horating.toString(), data.rating_name)
                    name.text = data.hotel_name
                    address.text = data.hotel_adress

                    from.text = data.departure
                    city.text = data.arrival_country
                    date.text = getString(R.string.date, data.tour_date_start, data.tour_date_stop)
                    days.text = getString(R.string.days, data.number_of_nights.toString())
                    hotel.text = data.hotel_name
                    number.text = data.room
                    charge.text = data.nutrition
                    tourCharge.text = getString(R.string.money, data.tour_price.toString())
                    fuelCharge.text = getString(R.string.money, data.fuel_charge.toString())
                    serviceCharge.text = getString(R.string.money, data.service_charge.toString())
                    totalCharge.text = getString(R.string.money, total.toString())
                    totalPrice.text = getString(R.string.money, total.toString())
                }
            }
            if (it.error.isNotBlank()) {
                Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
            }
        }
    }
}