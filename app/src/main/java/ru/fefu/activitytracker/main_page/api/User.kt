package ru.fefu.activitytracker.main_page.api

data class User(
    val id: Int,
    val name: String,
    val login: String,
    val gender: Gender,
)
