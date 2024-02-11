package com.jwmoon.awords

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jwmoon.awords.models.StudySet
import com.jwmoon.awords.ui.theme.AWordsTheme
import com.jwmoon.awords.views.StudySetList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AWordsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeView(StudySet.mockList)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(sets: List<StudySet>, modifier: Modifier = Modifier) {
    Column {
        TopAppBar(title = { Text("단어장 목록") })
        StudySetList(sets = sets)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AWordsTheme {
        HomeView(StudySet.mockList)
    }
}