package com.example.pointstracker

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var points = 0

    lateinit var pointsTextView: TextView //created variable for TextView to store and show value

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //find xml file
        pointsTextView = findViewById<TextView>(R.id.points)

        if(savedInstanceState != null && savedInstanceState!!.containsKey("points")){

           points = savedInstanceState.getInt("points")
            pointsTextView.text = points.toString()
        }

    }

    fun incrementPoint(view: View) {
        //this method is invoked as we click + button on the activity_main
        points++
        pointsTextView.text = points.toString() // show the value in  TextView
    }
    fun decrementPoint(view: View) {
        //this method is invoked as we click - button on the activity_main
        points--
        pointsTextView.text = points.toString() // show the value in  TextView
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("points",points)
    }

}