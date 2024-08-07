package ru.fefu.activitytracker.main_page.lists

class ListActivityTypes {
    private val listTypes = listOf(
        ActivityType(
            activity = "Велосипед",
            false,
        ),
        ActivityType(
            activity = "Бег",
            false
        ),
        ActivityType(
            activity = "Шаг",
            false
        ),
    )

    fun getItem(): List<ActivityType> = listTypes
}