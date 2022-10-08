package com.example.counterrmp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class secondActivity : AppCompatActivity() {
    private lateinit var textRandomInt: TextView

    private var counter: Int? = 0

    companion object {
        const val TOTAL_COUNT = "total_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textRandomInt = findViewById(R.id.textRandomInt)
        showRandomInt()
    }

    override fun onStart() {
        super.onStart()
    }

    private fun showRandomInt() {
        val count = intent.getIntExtra(TOTAL_COUNT, 0)
        counter = count
        textRandomInt.text = count.toString()
    }

    fun backActiveMain(view: View){
        val firstIntent = Intent(this, secondActivity::class.java)
//        firstIntent.putExtra(MainActivity.TOTAL_COUNT, counter)
        startActivity(firstIntent)
    }
}