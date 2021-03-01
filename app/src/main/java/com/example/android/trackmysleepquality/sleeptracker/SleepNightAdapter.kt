package com.example.android.trackmysleepquality.sleeptracker

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.TextItemViewHolder
import com.example.android.trackmysleepquality.database.SleepNight

class SleepNightAdapter: RecyclerView.Adapter<TextItemViewHolder>() {
    var data =  listOf<SleepNight>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

//    when the RecyclerView needs a view holder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
    val layoutInflater = LayoutInflater.from(parent.context)
    val view = layoutInflater
            .inflate(R.layout.text_item_view, parent, false) as TextView
    return TextItemViewHolder(view)
    }

//    RecyclerView to display the data for one list item at the specified position
    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
    val item = data[position]
    if (item.sleepQuality <= 1) {
        holder.textView.setTextColor(Color.RED) // red
    }
    holder.textView.text = item.sleepQuality.toString()
    }

//    RecyclerView needs to know how many items the adapter has for it to display
    override fun getItemCount() = data.size



}