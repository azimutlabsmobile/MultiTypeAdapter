package com.alabs.multiadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.alabs.multiadapter.viewBinders.CardViewBinder
import com.alabs.multiadapter.viewBinders.TextViewBinder
import com.alabs.multitypeadapter.multiTypeAdapter.MultiTypeAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /**
     *  !!! Only for example
     *  The @MultiTypeAdapter takes any kind of object to represent the recycler items.
     *  The list shown below contains two types like String and Int.
     */
    private val listItems = arrayListOf<Any>(
        "You can user several type of Object in single RecyclerView",
        "You can use several type of View in single RecyclerView",
        1, 2, 3, 4, 5, 6, 7
    )

    /**
     *  Despite to the difference of types which multiTypeAdapter takes for input,
     *  the registered viewBinders can define what kind of type they must be operated for output
     */
    private val multiAdapter = MultiTypeAdapter().apply {
        register(TextViewBinder())
        register(CardViewBinder {
            showMessage(it.toString())
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
        setupAdapter()
    }

    private fun setupView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = multiAdapter
        }
    }

    private fun setupAdapter() {
        multiAdapter.apply {
            items = listItems
            notifyDataSetChanged()
        }
    }

    private fun showMessage(msg: String) {
        Toast.makeText(this, "Your card number is $msg", Toast.LENGTH_SHORT).show()
    }
}