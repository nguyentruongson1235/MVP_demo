package com.example.mvp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvp.R
import com.example.mvp.models.Products
import com.example.mvp.utils.Constants
import com.example.mvp.extensions.loadFromUrl
import kotlinx.android.synthetic.main.item_viewholder.view.*

class RecyclerViewAdapter(private var data: MutableList<Products?>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return if (viewType == Constants.VIEW_TYPE_ITEM) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_viewholder, parent, false)
            ItemViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_viewholder, parent, false)
            LoadingViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            holder.bindData(data, position)
        }
    }

    override fun getItemCount() = data.size

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(listData: MutableList<Products?>, position: Int) {
            itemView.textTitleProduct.text = listData[position]?.title
            itemView.imageProduct.loadFromUrl(Constants.BASE_URL_IMAGE + listData[position]?.thumbnail)
        }
    }

    class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getItemViewType(position: Int): Int {
        return if (data[position] == null) {
            Constants.VIEW_TYPE_LOADING
        } else Constants.VIEW_TYPE_ITEM
    }
}
