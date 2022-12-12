package com.example.suksukenglish.model

import androidx.annotation.StringRes

data class EnglishItem(
    val id: Int,
    val chapter: Int,
    @StringRes val eiResourceId: Int,
    @StringRes val mResourceId: Int
)
