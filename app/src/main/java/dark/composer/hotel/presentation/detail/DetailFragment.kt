package dark.composer.hotel.presentation.detail

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import dark.composer.hotel.App
import dark.composer.hotel.R
import dark.composer.hotel.common.BaseFragment
import dark.composer.hotel.databinding.FragmentDetailBinding
import dark.composer.hotel.presentation.detail.adapter.AdapterHotels
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {
    private val adapter by lazy {
        AdapterHotels(requireContext())
    }

    @Inject
    lateinit var viewModel: DetailViewModel

    override fun onViewCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)

        arguments?.let {
            binding.title.text = it.getString("name","")
        }

        binding.rv.adapter = adapter

        getRooms()

        adapter.setItemLikeClickListener {
            navController.navigate(R.id.action_detailFragment_to_bookingFragment)
        }

        binding.back.setOnClickListener {
            navController.popBackStack()
        }
    }

    private fun getRooms() = lifecycleScope.launch {
        viewModel.getRooms().collectLatest {
            it.data?.let { data ->
                adapter.setList(data.rooms)
            }
            if (it.error.isNotBlank()) {
                Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
            }
        }
    }
}