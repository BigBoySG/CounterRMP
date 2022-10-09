package com.example.counterrmp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class secondActivity : AppCompatActivity() {
    private lateinit var textRandomInt: TextView

    private var counter: Int? = 0

    companion object {
        const val TOTAL_COUNT = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textRandomInt = findViewById(R.id.textRandomInt)
        showRandomInt()
    }

    private fun showRandomInt() {
        val count = intent.getIntExtra(TOTAL_COUNT, 0)
        counter = Random.nextInt(1, count)
        textRandomInt.text = counter.toString()
        counter = count
    }

    fun backActiveMain(view: View) {
        val firstIntent = Intent(this, MainActivity::class.java)
        firstIntent.putExtra(MainActivity.COUNT, counter)
        startActivity(firstIntent)
        finish()
    }
}