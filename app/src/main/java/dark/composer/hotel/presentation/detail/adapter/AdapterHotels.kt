package dark.composer.hotel.presentation.detail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dark.composer.domain.model.rooms.RoomModel
import dark.composer.hotel.R
import dark.composer.hotel.databinding.ItemHotelBinding
import dark.composer.hotel.presentation.main.adapter.PeculiaritiesAdapter
import dark.composer.hotel.presentation.main.adapter.ViewPagerAdapter
import dark.composer.hotel.utils.autoScroll

class AdapterHotels(private val context: Context) :
    RecyclerView.Adapter<AdapterHotels.ViewHolder>() {

    private val list = mutableListOf<RoomModel>()

    fun setList(data: List<RoomModel>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    private var itemLikeClickListener: (() -> Unit)? =
        null

    fun setItemLikeClickListener(f: () -> Unit) {
        itemLikeClickListener = f
    }

    inner class ViewHolder(private val binding: ItemHotelBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val adapterImage by lazy {
            ViewPagerAdapter(context)
        }

        private val adapterPeculiarities by lazy {
            PeculiaritiesAdapter()
        }

        fun bind(data: RoomModel) {
            binding.viewPager.adapter = adapterImage
            binding.list.adapter = adapterPeculiarities

            binding.dotsIndicator.attachTo(binding.viewPager)
            binding.viewPager.autoScroll(4000)

            binding.name.text = data.name
            binding.money.text = context.getString(R.string.money, data.price.toString())
            binding.text.text = data.price_per

            binding.next.setOnClickListener {
                itemLikeClickListener?.invoke()
            }

            adapterPeculiarities.setList(data.peculiarities)
            adapterImage.setList(data.image_urls)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemHotelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])
}