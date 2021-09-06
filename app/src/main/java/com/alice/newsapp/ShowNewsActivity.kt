package com.alice.newsapp

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.alice.newsapp.databinding.ActivityShowNewsBinding

class ShowNewsActivity : AppCompatActivity() {
    lateinit var binding: ActivityShowNewsBinding
    private val KEY = "NEWS"

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityShowNewsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}