package com.example.dragondropapp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class NumberAdapter(private val context: Context, private val numbers: List<Int>, private val rule: (Int) -> Boolean) : BaseAdapter() {

    override fun getCount(): Int = numbers.size

    override fun getItem(position: Int): Int = numbers[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
        val textView: TextView = view.findViewById(android.R.id.text1)

        val number = getItem(position)
        textView.text = number.toString()

        if (rule(number)) {
            textView.setBackgroundColor(Color.YELLOW)
        } else {
            textView.setBackgroundColor(Color.WHITE)
        }

        return view
    }
}
