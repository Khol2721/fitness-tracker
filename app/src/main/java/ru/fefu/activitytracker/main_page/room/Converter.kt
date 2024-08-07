package ru.fefu.activitytracker.main_page.room

import androidx.room.TypeConverter
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converter {
    @ExperimentalSerializationApi
    @TypeConverter
    fun fromList(list: List<Pair<Double, Double>>) = Json.encodeToString(list)

    @ExperimentalSerializationApi
    @TypeConverter
    fun toList(string: String) = Json.decodeFromString<List<Pair<Double, Double>>>(string)
}