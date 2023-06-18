package com.example.sultanapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sultanapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Sultan>("DATA")
        Log.e("Detail Data:", data?.name.toString())

        val actionbar = supportActionBar
        actionbar!!.title = data?.name
        actionbar.setDisplayHomeAsUpEnabled(true)

        if (data != null) {
            binding.ivBgDetail.setImageResource(data.photo_bg)
            binding.civDetail.setImageResource(data.photo)
            binding.tvNameDetail.text = data.name
            binding.tvKelahiran.text = data.birth
            binding.tvCompany.text = data.company
            binding.tvDesc.text = data.desc
        }
        binding.actionShare.setOnClickListener {
            val goShare = Intent()
            goShare.action = Intent.ACTION_SEND
            goShare.putExtra(Intent.EXTRA_TEXT, "Kamu ingin menjadi seperti: ${data?.name}")
            goShare.type = "text/plain"
            startActivity(Intent.createChooser(goShare, "Share To:"))
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}