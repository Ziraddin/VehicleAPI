package com.zireddinismayilov.vehicleapi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zireddinismayilov.vehicleapi.Model.Results
import com.zireddinismayilov.vehicleapi.R

class ManufacturersAdapter(var list: Results?, val onItemClick: OnItemClickListener) :
    RecyclerView.Adapter<ManufacturersAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Country = itemView.findViewById<TextView>(R.id.CountryItem_row_element)
        var Mfr_CommonName = itemView.findViewById<TextView>(R.id.CommonNameItem_row_element)
        var Mfr_Name = itemView.findViewById<TextView>(R.id.Mfr_Name_row_element)
        var Address = itemView.findViewById<TextView>(R.id.Address_row_element)
        var ContactEmail = itemView.findViewById<TextView>(R.id.ContactEmail_row_element)
        var ContactPhone = itemView.findViewById<TextView>(R.id.ContactPhone_row_element)

        init {
            itemView.setOnClickListener {
                onItemClick.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_element, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list?.Results?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Country.text = list?.Results?.get(position)?.Country
        holder.Mfr_CommonName.text = list?.Results?.get(position)?.Mfr_CommonName
        holder.Mfr_Name.text = list?.Results?.get(position)?.Mfr_Name

        if (list?.Results?.get(position)?.Address != null) {
            holder.Address.text = list?.Results?.get(position)?.Address
            holder.Address.visibility = View.VISIBLE
        } else {
            holder.Address.visibility = View.GONE
        }

        if (list?.Results?.get(position)?.ContactEmail != null) {
            holder.ContactEmail.text = list?.Results?.get(position)?.ContactEmail
            holder.ContactEmail.visibility = View.VISIBLE
        } else {
            holder.ContactEmail.visibility = View.GONE
        }

        if (list?.Results?.get(position)?.ContactPhone != null) {
            holder.ContactPhone.text = list?.Results?.get(position)?.ContactPhone
            holder.ContactPhone.visibility = View.VISIBLE
        } else {
            holder.ContactPhone.visibility = View.GONE
        }


    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}