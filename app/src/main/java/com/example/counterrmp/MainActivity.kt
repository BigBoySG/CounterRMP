package com.example.counterrmp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var textCounter: TextView

    private var counter = 0

    companion object {
        const val COUNT = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textCounter = findViewById(R.id.textCounter)
        counter = intent.getIntExtra(COUNT, 0)
        textCounter.text = counter.toString()
    }

    fun zeroCounter(view: View) {
        counter = 0
        textCounter.text = counter.toString()
    }

    fun randomInt(view: View) {
        if (counter > 0){
            val secondIntent = Intent(this, secondActivity::class.java)
            secondIntent.putExtra(secondActivity.TOTAL_COUNT, counter)
            startActivity(secondIntent)
            finish()
        }
    }

    fun plusCounter(view: View) {
        counter += 1
        textCounter.text = counter.toString()
        if (counter == 150) {
            Toast.makeText(this, "Займись делом, а не тыкай на '+'", Toast.LENGTH_LONG).show()
        }
    }

    fun minusCounter(view: View) {
        if (counter > 0) {
            counter -= 1
            textCounter.text = counter.toString()
        } else {
            Toast.makeText(this, "Минимальное число 0", Toast.LENGTH_SHORT).show()
        }
    }
}