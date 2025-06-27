package com.example.fetchexercise

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class FetchItemsAdapter(
    context: Context,
    private val resource: Int,
    items: List<FetchItems>)
    : ArrayAdapter<FetchItems>(context,resource,items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = convertView ?: View.inflate(context, resource, null)
        val fetchItem = getItem(position)

        val textView: TextView = view.findViewById(android.R.id.text1)
        textView.text = "List ID: ${fetchItem?.getListId()} , Name: ${fetchItem?.getName()}, ID: ${fetchItem?.getId()}"


        return view
    }
}