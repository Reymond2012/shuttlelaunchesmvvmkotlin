package com.example.shuttlelaunchesmvvmkotlin.home

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.ScrollingTabContainerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import com.example.shuttlelaunchesmvvmkotlin.R
import com.example.shuttlelaunchesmvvmkotlin.data.Breach
import com.example.shuttlelaunchesmvvmkotlin.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_breach.*

class ResultAdapter : RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {

    private val results = mutableListOf<Breach>()

    fun setData(data: List<Breach>?){
        data?.let {
            results.clear()
            results.addAll(data)
            notifyDataSetChanged()
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ResultViewHolder(parent.inflate(R.layout.item_breach))


    override fun getItemCount() = results.size



    override fun onBindViewHolder(viewHolder: ResultViewHolder, position: Int) {
        viewHolder.bind(results[position])

    }

    class ResultViewHolder (override val containerView:  View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bind(breach: Breach){
            tvName.text = breach.name
            tvDescription.text = breach.description
        }
    }



}