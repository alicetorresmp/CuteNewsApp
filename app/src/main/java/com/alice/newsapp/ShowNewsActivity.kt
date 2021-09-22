package com.alice.newsapp

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.alice.newsapp.databinding.ActivityShowNewsBinding

class ShowNewsActivity : AppCompatActivity() {
    lateinit var binding: ActivityShowNewsBinding
    private val KEY = "NEWS_INFO"
    private lateinit var newsTitle : String
    private lateinit var newsUrl : String

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityShowNewsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val arrayList: ArrayList<Data> = ArrayList()


        val customAdapter : CustomAdapter = CustomAdapter (arrayList)
        binding.listView.adapter = customAdapter


    }
}