package dark.composer.hotel.presentation.booking.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dark.composer.hotel.databinding.ItemTousistsAdditionsBinding

class AdapterAdditional:RecyclerView.Adapter<AdapterAdditional.ViewHolder>() {

    private val list = mutableListOf<String>()

    fun setList(data:List<String>){
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    fun addItem(data:String){
        list.add(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding:ItemTousistsAdditionsBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(data:String){
            binding.title.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemTousistsAdditionsBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])
}