package com.chidi.funfact

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.chidi.funfact.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private var binding: ActivityDetailBinding? = null

    private var logo = 0
    private var name: String? = null
    private var details: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        logo = intent.getIntExtra(FactAdapter.LOGO_EXTRAS, 0)
        name = intent.getStringExtra(FactAdapter.NAME_EXTRAS)
        details = intent.getStringExtra(FactAdapter.FACT_EXTRAS)
        setupFactDetails()
    }

    private fun setupFactDetails() {
        title = name
        binding?.detailsLogo?.setImageResource(logo)
        binding?.detailsContent?.text = details
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}