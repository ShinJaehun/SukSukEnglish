package com.example.suksukenglish.data

import com.example.suksukenglish.R
import com.example.suksukenglish.model.Chapter
import com.example.suksukenglish.model.EnglishItem

object SSEDataProvider {

//    fun getCategoryData(currentCategoryItem: CategoryItemContent): List<JejuItemContent> {
//        return getJejuData().filter {
//            it.categoryResourceId == currentCategoryItem.categoryResourceId
//        }
//    }

    fun getEnglisItem(id: Int): EnglishItem? {
        return getSSEData().find {
            it.id == id
        }
    }

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
            ),
            EnglishItem(
                id = 3,
                chapter = 1,
                eiResourceId = R.string.eiYBM_5_1_03,
                mResourceId = R.string.mYBM_5_1_03
            ),
            EnglishItem(
                id = 4,
                chapter = 1,
                eiResourceId = R.string.eiYBM_5_1_04,
                mResourceId = R.string.mYBM_5_1_04
            )



        )
    }

}