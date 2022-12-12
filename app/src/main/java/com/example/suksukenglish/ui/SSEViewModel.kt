package com.example.suksukenglish.ui

import androidx.lifecycle.ViewModel
import com.example.suksukenglish.data.SSEDataProvider
import com.example.suksukenglish.model.Chapter
import com.example.suksukenglish.model.EnglishItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class SSEViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        SSEUiState(
            chapterList = SSEDataProvider.getChapterData(),
            currentChapter = SSEDataProvider.getChapterData().getOrElse(0){
                SSEDataProvider.getChapterData()[0]
            },
            englishItemList = SSEDataProvider.getSSEData(),
            currentEnglishItem = SSEDataProvider.getSSEData().getOrElse(0){
                SSEDataProvider.getSSEData()[0]
            }
        )
    )
    val uiState: StateFlow<SSEUiState> = _uiState

    fun updateCurrentChapter(selectedChapter: Chapter) {
        _uiState.update {
            it.copy(currentChapter = selectedChapter)
        }
    }

    fun updateCurrentEnglishItem(selectedEnglishItem: EnglishItem) {
        _uiState.update {
            it.copy(currentEnglishItem = selectedEnglishItem)
        }
    }
}