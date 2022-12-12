package com.example.suksukenglish.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.suksukenglish.MainActivity
import com.example.suksukenglish.R
import com.example.suksukenglish.data.SSEDataProvider
import com.example.suksukenglish.ui.utils.SSEContentType


enum class SSEScreen(@StringRes val title: Int){
    Menu(title = R.string.screen_menu),
    Blinker(title = R.string.screen_blinker),
}

@Composable
fun SSEApp(
    windowSize: WindowWidthSizeClass,
    activity: MainActivity,
    modifier: Modifier = Modifier
){
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = SSEScreen.valueOf(
        backStackEntry?.destination?.route ?: SSEScreen.Menu.name
    )
    val contentType: SSEContentType
    val viewModel: SSEViewModel = viewModel()

    when(windowSize) {
        WindowWidthSizeClass.Medium,
        WindowWidthSizeClass.Expanded -> {
            contentType = SSEContentType.ListAndDetail
        }
        else -> {
            contentType = SSEContentType.ListOnly
        }
    }

    Scaffold(
        topBar = {

        }
    ) {
        innerPadding ->
        val uiState by viewModel.uiState.collectAsState()
        if (contentType == SSEContentType.ListOnly) {
            NavHost(
                navController = navController,
                startDestination = SSEScreen.Menu.name,
                modifier = modifier.padding(innerPadding)
            ) {
                composable(route = SSEScreen.Menu.name) {
                    MenuScreen(
                        chapterList = SSEDataProvider.getChapterData(),
                        onClick = {
                            viewModel.updateCurrentChapter(it)
                            navController.navigate(SSEScreen.Blinker.name)
                        },
                        onBackPressed = {
                            activity.finish()
                        }
                    )
                }
                composable(route = SSEScreen.Blinker.name) {
//                    BlinkerScreen(
//                        currentEnglishItem = uiState.currentEnglishItem,
//                        onBackPressed = {
//                            navController.navigate(SSEScreen.Menu.name)
//                        }
//                    )
                }
            }
        } else {
//            SSEListAndDetails(
//
//            )
        }
    }
}