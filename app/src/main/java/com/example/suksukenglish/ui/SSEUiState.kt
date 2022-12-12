package com.example.suksukenglish.ui

import com.example.suksukenglish.data.SSEDataProvider
import com.example.suksukenglish.model.Chapter
import com.example.suksukenglish.model.EnglishItem

data class SSEUiState (
    val chapterList: List<Chapter> = emptyList(),
    val currentChapter: Chapter = SSEDataProvider.getChapterData()[0],
    val englishItemList: List<EnglishItem> = emptyList(),
    val currentEnglishItem: EnglishItem = SSEDataProvider.getSSEData()[0],
)