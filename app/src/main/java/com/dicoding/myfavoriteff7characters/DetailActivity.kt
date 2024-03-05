package com.dicoding.myfavoriteff7characters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataChar = intent.getParcelableExtra<Characters>("key_char")

        val tvDetailName = findViewById<TextView>(R.id.tv_detail_name)
        val tvDetailDescription = findViewById<TextView>(R.id.tv_detail_description)
        val ivDetailPhoto = findViewById<ImageView>(R.id.iv_detail_photo)

        if (dataChar != null) {
            tvDetailName.text = dataChar.name
            tvDetailDescription.text = dataChar.description

            Glide.with(this)
                .load(dataChar.photo)
                .into(ivDetailPhoto)
        }
    }
}
