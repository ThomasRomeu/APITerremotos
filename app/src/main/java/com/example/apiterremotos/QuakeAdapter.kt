package com.example.apiterremotos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class QuakeAdapter() : ListAdapter<Feature, QuakeAdapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Feature) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private lateinit var textViewPlace: TextView
        private lateinit var textViewMagnitud: TextView

        fun bind (feature: Feature) {
            textViewPlace = view.findViewById(R.id.textViewPlace)
            textViewMagnitud = view.findViewById(R.id.textViewMagnitud)

            textViewPlace.text = feature.properties.place
            textViewMagnitud.text = feature.properties.mag.toString()

            view.setOnClickListener {
                onItemClickListener(feature)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuakeAdapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuakeAdapter.ViewHolder, position: Int) {
        val feature = getItem(position)
        holder.bind(feature)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Feature>() {
        override fun areItemsTheSame(oldItem: Feature, newItem: Feature): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Feature, newItem: Feature): Boolean {
            return oldItem == newItem
        }
    }
}