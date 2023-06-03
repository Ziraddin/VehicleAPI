package com.zireddinismayilov.vehicleapi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zireddinismayilov.vehicleapi.Model.Results
import com.zireddinismayilov.vehicleapi.R

class ManufacturersAdapter(var list: Results) : RecyclerView.Adapter<ManufacturersAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Country = itemView.findViewById<TextView>(R.id.Country)
        var Mfr_CommonName = itemView.findViewById<TextView>(R.id.Mfr_CommonName)
        var Mfr_Name = itemView.findViewById<TextView>(R.id.Mfr_Name)
        var Mfr_ID = itemView.findViewById<TextView>(R.id.Mfr_ID)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_element, parent, false))
    }

    override fun getItemCount(): Int {
        return list.Results.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Country.setText(list.Results[position].Country)
        holder.Mfr_CommonName.setText(list.Results[position].Mfr_CommonName)
        holder.Mfr_Name.setText(list.Results[position].Mfr_Name)
        holder.Mfr_ID.setText(list.Results[position].Mfr_ID)
    }
}