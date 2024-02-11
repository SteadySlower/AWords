package com.jwmoon.awords.models

import java.time.LocalDate
import java.util.Date

enum class FrontType {
    KANJI, MEANING;

    val pickerText: String
        get() = when (this) {
            MEANING -> "한"
            KANJI -> "漢"
        }

    val preferredTypeText: String
        get() = when (this) {
            MEANING -> "뜻 앞면"
            KANJI -> "일본어 앞면"
        }

    companion object {
        val allValues: Array<FrontType>
            get() = values()
    }
}

enum class SetSchedule {
    NONE,
    STUDY,
    REVIEW;

    companion object {
        val allValues: Array<SetSchedule>
            get() = values()
    }
}
data class StudySet(
    val id: String,
    val title: String,
    val createdAt: LocalDate,
    val closed: Boolean,
    val preferredFrontType: FrontType,
    val isAutoSchedule: Boolean
)
