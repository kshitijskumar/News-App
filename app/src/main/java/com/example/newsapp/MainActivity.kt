package com.example.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapp.ui.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cvTopHeadlines.setOnClickListener{
            val intent= Intent(this, TopHeadlines::class.java)
            startActivity(intent)
        }

        cvScience.setOnClickListener {
            val intent= Intent(this, Science::class.java)
            startActivity(intent)
        }

        cvHealth.setOnClickListener {
            val intent= Intent(this, Health::class.java)
            startActivity(intent)
        }

        cvBusiness.setOnClickListener {
            val intent= Intent(this, Business::class.java)
            startActivity(intent)
        }

        cvEntertainment.setOnClickListener {
            val intent= Intent(this, Entertainment::class.java)
            startActivity(intent)
        }

        cvSports.setOnClickListener {
            val intent= Intent(this, Sports::class.java)
            startActivity(intent)
        }
    }

}

