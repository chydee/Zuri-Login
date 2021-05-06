package com.chidi.funfact

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chidi.funfact.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private lateinit var adapter: FactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setUpFacts()
    }

    private fun setUpFacts() {
        adapter = FactAdapter(this, DummyData.facts)
        binding?.factListView?.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}