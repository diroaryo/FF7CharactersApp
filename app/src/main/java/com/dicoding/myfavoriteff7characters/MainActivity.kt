package com.dicoding.myfavoriteff7characters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvCharacters: RecyclerView
    private val list = ArrayList<Characters>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCharacters = findViewById(R.id.rv_characters)
        rvCharacters.setHasFixedSize(true)
        list.addAll(getListHeroes())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvCharacters.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvCharacters.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.about_page -> {
                val intentAbout = Intent(this, About::class.java)
                startActivity(intentAbout)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun getListHeroes(): ArrayList<Characters> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listChar = ArrayList<Characters>()
        for (i in dataName.indices) {
            val hero = Characters(dataName[i], dataDescription[i], dataPhoto[i])
            listChar.add(hero)
        }
        return listChar
    }

    private fun showRecyclerList() {
        rvCharacters.layoutManager = LinearLayoutManager(this)
        val listCharAdapter = ListCharAdapters(list)
        rvCharacters.adapter = listCharAdapter

        listCharAdapter.setOnItemClickCallback(object : ListCharAdapters.OnItemClickCallback {
            override fun onItemClicked(data: Characters) {
                showSelectedHero(data)
            }
        })
    }

    private fun showSelectedHero(char: Characters) {
        val intentDetail = Intent(this, DetailActivity::class.java)
        intentDetail.putExtra("key_char", char)
        startActivity(intentDetail)
    }
}