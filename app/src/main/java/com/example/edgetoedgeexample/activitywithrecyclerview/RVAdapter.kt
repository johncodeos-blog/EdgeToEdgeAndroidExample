package com.example.edgetoedgeexample.activitywithrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.edgetoedgeexample.R
import kotlinx.android.synthetic.main.activity_with_recyclerview_row.view.*

class RVAdapter(private val cells: ArrayList<String>?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var context: Context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_with_recyclerview_row, parent, false)
        val vh = ViewHolder(v)
        context = parent.context
        return vh
    }

    override fun getItemCount(): Int {
        return cells?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.row_title_textview.text = cells?.get(position) ?: ""
    }
}