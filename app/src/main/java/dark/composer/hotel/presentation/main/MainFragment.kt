package dark.composer.hotel.presentation.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import dark.composer.hotel.App
import dark.composer.hotel.R
import dark.composer.hotel.common.BaseFragment
import dark.composer.hotel.databinding.FragmentMainBinding
import dark.composer.hotel.presentation.main.adapter.PeculiaritiesAdapter
import dark.composer.hotel.presentation.main.adapter.ViewPagerAdapter
import dark.composer.hotel.utils.autoScroll
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    private val adapterImage by lazy {
        ViewPagerAdapter(requireContext())
    }

    private val adapterPeculiarities by lazy {
        PeculiaritiesAdapter()
    }

    @Inject
    lateinit var viewModel: MainViewModel

    private var name = ""

    override fun onViewCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)

        binding.viewPager.adapter = adapterImage
        binding.list.adapter = adapterPeculiarities

        binding.dotsIndicator.attachTo(binding.viewPager)
        binding.viewPager.autoScroll(4000)

        getHotel()

        binding.next.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_detailFragment, bundleOf("name" to name))
        }
    }

    private fun getHotel() = lifecycleScope.launch {
        viewModel.getHotel().collectLatest {
            it.data?.let { data ->

                binding.apply {
                    adapterImage.setList(data.image_urls)

                    rating.text =
                        getString(R.string.rating, data.rating.toString(), data.rating_name)
                    name.text = data.name
                    address.text = data.adress
                    money.text = getString(R.string.begin_money, data.minimal_price.toString())
                    forTour.text = data.price_for_it
                    this@MainFragment.name = data.name
                    adapterPeculiarities.setList(data.about_the_hotel.peculiarities)
                    description.text = data.about_the_hotel.description
                }

                Log.d("hotel_data", "getHotel: $data")
            }
            if (it.error.isNotBlank()) {
                Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
            }
        }
    }

}