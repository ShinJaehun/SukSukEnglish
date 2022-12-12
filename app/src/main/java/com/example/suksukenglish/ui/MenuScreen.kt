package com.example.suksukenglish.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.suksukenglish.model.Chapter
import com.example.suksukenglish.model.EnglishItem

@Composable
fun MenuScreen(
    chapterList: List<Chapter>,
    onClick: (Chapter) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler() {
        onBackPressed()
    }
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(chapterList) {
            ChapterCard(
                chapter = it,
                onChapterClick = onClick
            )
        }
    }
}

@Composable
fun ChapterCard(
    chapter: Chapter,
    onChapterClick: (Chapter) -> Unit,
    modifier: Modifier = Modifier
) {
//    Card(
//
//    )
}