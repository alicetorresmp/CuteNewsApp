package com.alice.newsapp

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.alice.newsapp.databinding.ActivityShowNewsBinding
import com.alice.newsapp.databinding.ListItemBinding
import java.util.ArrayList

class ShowNewsActivity : AppCompatActivity() {
    lateinit var binding1: ActivityShowNewsBinding
    lateinit var binding2: ListItemBinding
    private val KEY = "NEWS_INFO"

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding1 = ActivityShowNewsBinding.inflate(layoutInflater)
        binding2 = ListItemBinding.inflate(layoutInflater)
        val view1 = binding1.root
        val view2 = binding2.root
        val news_array_list = intent.getStringArrayListExtra(KEY)

        binding1.listView.adapter = MyCustomAdapter(this, news_array_list)
    }
}

class MyCustomAdapter(context: ShowNewsActivity, val arrayList: ArrayList<String>?, val view: View) : BaseAdapter() {
    private val mContext = context

    override fun getCount(): Int = arrayList!!.size

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): LinearLayout {
        TODO("Not yet implemented")
    }

}