package com.alice.newsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alice.newsapp.databinding.ActivityMainBinding
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import com.alice.newsapp.ShowNewsActivity as ShowNewsActivity1

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val KEY = "NEWS_INFO"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val queue = Volley.newRequestQueue(this)
        val url = getUrl()

        binding.searchButton.setOnClickListener {
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                { response ->
                    try {
                        extractNewsFromJson()
                    } catch (exception: Exception) {
                        exception.printStackTrace()
                    }
                },
                { error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                }
            )
            queue.add(stringRequest)
        }
    }
        private fun getUrl(): String {
            val word = binding.keyword.text
            val apiKey = "adc2177b-809b-4165-818f-98658d273621"
            return "https://content.guardianapis.com/$word?page=1&page-size=10&api-key=$apiKey"
        }

    private fun extractNewsFromJson() {
        val jsonArray = JSONArray("results")
        val listdata = ArrayList<String>()
        val jArray = jsonArray as JSONArray?
        if (jArray != null) {
            for (i in 0 until jArray.length()) {
                listdata.add(jArray.getString(i))
            }
        }

        val intent =  Intent(
            this,
            ShowNewsActivity1::class.java
        )
        intent.putStringArrayListExtra(KEY, listdata)
        startActivity(intent)
    }
}
