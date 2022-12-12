package com.example.suksukenglish.data

import com.example.suksukenglish.R
import com.example.suksukenglish.model.Chapter
import com.example.suksukenglish.model.EnglishItem

object SSEDataProvider {

    fun getChapterData(): List<Chapter> {
        return listOf(
            Chapter(
                ch = 1,
                titleResourceId = R.string.title_ch01
            ),
            Chapter(
                ch = 2,
                titleResourceId = R.string.title_ch02
            )
        )
    }

    fun getSSEData(): List<EnglishItem> {
        return listOf(
            EnglishItem(
                id = 1,
                chapter = 1,
                eiResourceId = R.string.eiYBM_5_1_01,
                mResourceId = R.string.mYBM_5_1_01
            ),
            EnglishItem(
                id = 2,
                chapter = 1,
                eiResourceId = R.string.eiYBM_5_1_02,
                mResourceId = R.string.mYBM_5_1_02
            )
        )
    }

}