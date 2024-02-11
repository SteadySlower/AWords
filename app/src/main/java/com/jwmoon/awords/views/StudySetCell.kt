package com.jwmoon.awords.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jwmoon.awords.models.FrontType
import com.jwmoon.awords.models.SetSchedule
import com.jwmoon.awords.models.StudySet
import java.time.LocalDate

@Composable
fun StudySetCell(studySet: StudySet, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(12.dp).background(color = Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = studySet.title,
                color = Color.Black
            )
            Spacer(modifier = Modifier.weight(1f))
        }
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = studySet.createdAt.toString(),
                color = getDateTextColor(studySet.schedule),
                textAlign = TextAlign.End
            )
        }
    }
}

private fun getDateTextColor(schedule: SetSchedule): Color {
    return when (schedule) {
        SetSchedule.NONE -> Color.Black
        SetSchedule.STUDY -> Color.Blue
        SetSchedule.REVIEW -> Color.Magenta
    }
}

@Preview
@Composable
fun PreViewStudySetCell() {
    StudySetCell(studySet = StudySet(
        id = "1",
        title = "1번 단어장",
        createdAt = LocalDate.now(),
        closed = false,
        preferredFrontType = FrontType.KANJI,
        isAutoSchedule = true
    ))
}