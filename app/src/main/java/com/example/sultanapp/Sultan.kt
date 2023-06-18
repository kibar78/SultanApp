package com.example.sultanapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sultan(
    val name: String,
    val quote: String,
    val photo: Int,
    val photo_bg: Int,
    val birth: String,
    val company: String,
    val desc: String
): Parcelable
