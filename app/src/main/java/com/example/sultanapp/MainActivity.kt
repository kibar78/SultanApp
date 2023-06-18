package com.example.sultanapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvSultan: RecyclerView
    private val list = ArrayList<Sultan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title = "Orang Terkaya"

        rvSultan = findViewById(R.id.rv_sultan)
        rvSultan.setHasFixedSize(true)

        list.addAll(getListSultan())
        showRecyclerList()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.about ->{
                val goAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(goAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun getListSultan(): ArrayList<Sultan> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataQuote = resources.getStringArray(R.array.data_quote)
        val dataPhoto = resources.obtainTypedArray(R.array.photo)
        val dataPhotoBg = resources.obtainTypedArray(R.array.photo_bg)
        val dataBirth = resources.getStringArray(R.array.birth)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val listSultan = ArrayList<Sultan>()
        for (i in dataName.indices) {
            val sultan = Sultan(dataName[i], dataQuote[i], dataPhoto.getResourceId(i, -1),dataPhotoBg.getResourceId(i,-1)
            ,dataBirth[i],dataCompany[i],dataDesc[i])
            listSultan.add(sultan)
        }
        return listSultan
    }

    private fun showRecyclerList() {
        rvSultan.layoutManager = LinearLayoutManager(this)
        val sultanAdapter = SultanAdapter(list)
        rvSultan.adapter = sultanAdapter
        sultanAdapter.setOnItemClickCallback(object : SultanAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Sultan) {
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra("DATA",data)
                startActivity(intentToDetail)
            }
        })
    }

}