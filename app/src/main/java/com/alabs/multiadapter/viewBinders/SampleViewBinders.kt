package com.alabs.multiadapter.viewBinders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alabs.multiadapter.R
import com.alabs.multitypeadapter.multiTypeAdapter.ItemViewBinder
import kotlinx.android.synthetic.main.item_card_view.view.*
import kotlinx.android.synthetic.main.item_text_view.view.*
import kotlinx.android.synthetic.main.item_text_view.view.textView

class TextViewBinder : ItemViewBinder<String, TextViewBinder.ViewHolder>() {

    override fun onCreateViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ) = ViewHolder(inflater.inflate(R.layout.item_text_view, parent, false))

    override fun onBindViewHolder(holder: TextViewBinder.ViewHolder, item: String) {
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: String) = with(itemView) {
            textView.text = item
        }
    }
}

class CardViewBinder(
    private val onCardClicked: ((Int) -> Unit)
) : ItemViewBinder<Int, CardViewBinder.ViewHolder>() {

    override fun onCreateViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ) = ViewHolder(inflater.inflate(R.layout.item_card_view, parent, false))

    override fun onBindViewHolder(holder: CardViewBinder.ViewHolder, item: Int) {
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Int) = with(itemView) {
            numberView.text = item.toString()
            cardView.setOnClickListener {
                onCardClicked.invoke(item)
            }
        }
    }
}