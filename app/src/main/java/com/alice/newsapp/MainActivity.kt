package com.alice.newsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alice.newsapp.databinding.ActivityMainBinding
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val KEY = "NEWS"

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
                        extractDefinitionFromJson(response)
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

        private fun extractDefinitionFromJson(response: String) {
            val jsonObject = JSONObject(response)
            val getResults = jsonObject.getJSONArray("results")
            for (index: Int in 0..9) {
                val getPublication = getResults.getJSONObject(index)
                val getWebTitle = getPublication.get("webTitle")
                val getWebUrl = getPublication.get("webUrl")

                val intent = Intent(this, ShowNewsActivity::class.java)
                intent.putExtra(KEY, getWebTitle.toString())
                intent.putExtra(KEY, getWebUrl.toString())
                startActivity(intent)
            }
        }
    }
