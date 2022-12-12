package com.example.suksukenglish.model

import androidx.annotation.StringRes

data class Chapter (
    val ch: Int,
    @StringRes val titleResourceId: Int,
)