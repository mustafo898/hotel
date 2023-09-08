package dark.composer.hotel.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dark.composer.hotel.databinding.ItemTextBinding
import dark.composer.hotel.databinding.ItemTousistsAdditionsBinding

class PeculiaritiesAdapter:RecyclerView.Adapter<PeculiaritiesAdapter.ViewHolder>() {

    private val list = mutableListOf<String>()

    fun setList(data:List<String>){
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding:ItemTextBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(data:String){
            binding.text.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemTextBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])
}