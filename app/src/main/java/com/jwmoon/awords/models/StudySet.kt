package com.jwmoon.awords.models

import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.Calendar
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
) {
    val dayFromToday: Int
        get() = ChronoUnit.DAYS.between(createdAt, LocalDate.now()).toInt()

    val schedule: SetSchedule
        get() {
            val reviewInterval = listOf(3, 7, 14, 28)

            return when {
                dayFromToday in 0 until 3 -> SetSchedule.STUDY
                dayFromToday in reviewInterval -> SetSchedule.REVIEW
                else -> SetSchedule.NONE
            }
        }

    // preview를 위한 생성자
    constructor(idx: Int) : this(
        "$idx",
        "$idx 번 단어장",
        LocalDate.now(),
        false,
        FrontType.KANJI,
        true
    )

    companion object {
        val mockArray: Array<StudySet> by lazy {
            (0 until 10).map { StudySet(it) }.toTypedArray()
        }
    }
}
