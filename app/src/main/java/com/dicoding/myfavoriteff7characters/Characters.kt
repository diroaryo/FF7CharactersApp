package com.dicoding.myfavoriteff7characters

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Characters(
    val name: String,
    val description: String,
    val photo: String
) : Parcelable
