package com.example.gtropy.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gtropy.R
import com.example.gtropy.databinding.ItemVehicleBinding
import com.example.gtropy.ui.model.VehicleList
import com.example.gtropy.utils.RecyclerViewClickListener
import java.util.*


class VehicleListAdapter(var listener: RecyclerViewClickListener<VehicleList>):RecyclerView.Adapter<VehicleListAdapter.VehicleListViewHolder>() {

    private lateinit var vehicleList:List<VehicleList>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleListViewHolder {
        val binding: ItemVehicleBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_vehicle, parent, false)
        return VehicleListViewHolder(binding)
    }

    fun updateList(vehicleList: List<VehicleList>){
        if(!vehicleList.isNullOrEmpty()){
            this.vehicleList = vehicleList
            notifyDataSetChanged()
        }

    }
    override fun getItemCount(): Int {
        return if(::vehicleList.isInitialized) vehicleList.size else 0
    }

    override fun onBindViewHolder(holder: VehicleListViewHolder, position: Int) {
        holder.bind(vehicleList[position])
    }

    inner class VehicleListViewHolder(var itemVehicleBinding: ItemVehicleBinding):RecyclerView.ViewHolder(itemVehicleBinding.root){
        init {
            itemVehicleBinding.cardview.setCardBackgroundColor(getRandomColor())

        }
        fun bind(vehicleList: VehicleList){
            itemVehicleBinding.data = vehicleList
            itemVehicleBinding.cl.setOnClickListener{
                listener.onRecyclerViewItemClick(vehicleList)
            }
        }
    }

    fun getRandomColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}