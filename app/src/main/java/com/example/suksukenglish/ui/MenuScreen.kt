package com.example.suksukenglish.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.suksukenglish.data.SSEDataProvider
import com.example.suksukenglish.model.Chapter
import com.example.suksukenglish.model.EnglishItem
import com.example.suksukenglish.ui.theme.SukSukEnglishTheme

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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChapterCard(
    chapter: Chapter,
    onChapterClick: (Chapter) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 5.dp,
        onClick = { onChapterClick(chapter) },
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp)
        ) {
            Text(
                text = stringResource(id = chapter.titleResourceId),
                modifier = Modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChapterCardPreview(){
    SukSukEnglishTheme {
        ChapterCard(chapter = SSEDataProvider.getChapterData()[0], onChapterClick = {})
    }
}