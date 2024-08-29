package com.example.dragondropapp

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.GridView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.common.math.IntMath.isPrime
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var gridView: GridView
    private lateinit var spinner: Spinner
    private val numbers = (1..100).toList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView = findViewById(R.id.gridView)
        spinner = findViewById(R.id.rule_spinner)

        val rules = mapOf(
            "Odd Numbers" to ::isOdd,
            "Even Numbers" to ::isEven,
            "Prime Numbers" to ::isPrime,
            "Fibonacci Numbers" to ::isFibonacci
        )

        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, rules.keys.toList())

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedRule = rules.values.toList()[position]
                gridView.adapter = NumberAdapter(this@MainActivity, numbers, selectedRule)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Initialize with the first rule selected
        gridView.adapter = NumberAdapter(this, numbers, rules.values.first())
    }



    fun isOdd(number: Int) = number % 2 != 0

    fun isEven(number: Int) = number % 2 == 0

    fun isPrime(number: Int): Boolean {
        if (number < 2) return false
        for (i in 2..Math.sqrt(number.toDouble()).toInt()) {
            if (number % i == 0) return false
        }
        return true
    }

    fun isFibonacci(number: Int): Boolean {
        fun isPerfectSquare(x: Int): Boolean {
            val s = Math.sqrt(x.toDouble()).toInt()
            return s * s == x
        }
        return isPerfectSquare(5 * number * number + 4) || isPerfectSquare(5 * number * number - 4)
    }









}
