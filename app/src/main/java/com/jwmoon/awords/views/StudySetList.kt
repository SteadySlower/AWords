package com.jwmoon.awords.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jwmoon.awords.models.FrontType
import com.jwmoon.awords.models.StudySet
import com.jwmoon.awords.views.StudySetCell
import java.time.LocalDate

@Composable
fun StudySetList(sets: List<StudySet>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 20.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(20.dp))
        }
        sets.forEach { set ->
            item {
                StudySetCell(studySet = set)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Preview
@Composable
fun PreViewStudySetList() {
    StudySetList(sets = List(10) { index ->
        StudySet(idx = index + 1)
    }
    )
}