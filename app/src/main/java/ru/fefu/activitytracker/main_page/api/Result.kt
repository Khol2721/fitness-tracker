package ru.fefu.activitytracker.main_page.api

sealed class Result<T> {
    class Success<T>(val result: T): Result<T>()
    class Errors<T>(val errors: Throwable): Result<T>()
}