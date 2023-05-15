package com.example.apiexample1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.apiexample1.databinding.HospitalLayoutBinding

class HospitalAdapter : RecyclerView.Adapter<HospitalAdapter.ViewHolder>() {

    private var hospitalList = ArrayList<Data>()
    fun setHospitalList(hospitalList: List<Data>) {
        this.hospitalList = hospitalList as ArrayList<Data>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: HospitalLayoutBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalAdapter.ViewHolder {
        return ViewHolder(
            HospitalLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: HospitalAdapter.ViewHolder, position: Int) {
        val item = hospitalList[position]
        holder.binding.tvBranchName.text = item.branch_name
        holder.binding.imageView.load(item.divImage) {
            crossfade(true)
        }
        holder.binding.tvDivName.text = item.divName
    }

    override fun getItemCount(): Int {
        return hospitalList.size
    }

}