package com.example.edgetoedgeexample.activitywithrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.edgetoedgeexample.R

class RVAdapter(private val cells: ArrayList<String>?) :
    RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rowTitleTextView: TextView = itemView.findViewById(R.id.row_title_textview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.activity_with_recyclerview_row, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return cells?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rowTitleTextView.text = cells?.get(position) ?: ""
    }
}