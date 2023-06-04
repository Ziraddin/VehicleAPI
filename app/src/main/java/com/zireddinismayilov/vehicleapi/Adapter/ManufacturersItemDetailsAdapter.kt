package com.zireddinismayilov.vehicleapi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zireddinismayilov.vehicleapi.Model.VehicleTypes
import com.zireddinismayilov.vehicleapi.R

class ManufacturersItemDetailsAdapter(var list: List<VehicleTypes>) :
    RecyclerView.Adapter<ManufacturersItemDetailsAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var IsPrimary = itemView.findViewById<TextView>(R.id.IsPrimary_row_item_details)
        var Name = itemView.findViewById<TextView>(R.id.Name_row_item_details)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_item_details, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.IsPrimary.setText(list[position].IsPrimary.toString())
        holder.Name.setText(list[position].Name)
    }
}