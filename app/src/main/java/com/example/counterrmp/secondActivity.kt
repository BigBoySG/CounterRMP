package com.example.counterrmp


import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random


class secondActivity : AppCompatActivity() {
    private lateinit var textRandomInt: TextView
    private lateinit var backButton: Button

    private var counter: Int? = 0

    companion object {
        const val TOTAL_COUNT = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textRandomInt = findViewById(R.id.textRandomInt)
        backButton = findViewById(R.id.button)
        showRandomInt()
    }

    private fun showRandomInt() {
        counter = intent.getIntExtra(TOTAL_COUNT, 0)
        val randomCount = Random.nextInt(1, counter!!)
        textRandomInt.text = randomCount.toString()
        backButton.setBackgroundColor(
            Color.argb(
                255,
                25 * (randomCount % 10) * Random.nextInt(0, 2),
                25 * (randomCount % 10) * Random.nextInt(0, 2),
                25 * (randomCount % 10) * Random.nextInt(0, 2)
            )
        )
        Toast.makeText(this, (25 * (randomCount % 10)).toString(), Toast.LENGTH_LONG).show()

    }

    fun backActiveMain(view: View) {
        val firstIntent = Intent(this, MainActivity::class.java)
        firstIntent.putExtra(MainActivity.COUNT, counter)
        startActivity(firstIntent)
        finish()
    }
}