package com.example.suksukenglish.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.suksukenglish.data.SSEDataProvider
import com.example.suksukenglish.model.EnglishItem

@Composable
fun BlinkerScreen(
   viewModel: SSEViewModel,
   navController: NavController,
   currentEnglishItem: EnglishItem,
   onBackPressed: () -> Unit,
   modifier: Modifier = Modifier
) {
    BackHandler() {
        onBackPressed()
    }
    EnglishItemCard(
        englishItem = currentEnglishItem,
        onItemClick = {
            viewModel.updateCurrentEnglishItem(
                SSEDataProvider.getEnglisItem(currentEnglishItem.id + 1) ?: SSEDataProvider.getSSEData()[0]
            )
            navController.navigate(SSEScreen.Blinker.name)
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EnglishItemCard(
    englishItem: EnglishItem,
    onItemClick: (EnglishItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 5.dp,
        onClick = { onItemClick(englishItem) },
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp)
        ) {
            Text(
                text = stringResource(id = englishItem.eiResourceId),
                modifier = Modifier
            )
            Text(
                text = stringResource(id = englishItem.mResourceId),
                modifier = Modifier
            )
        }
    }
}