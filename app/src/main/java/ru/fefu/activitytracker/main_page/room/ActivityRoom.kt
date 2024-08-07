package ru.fefu.activitytracker.main_page.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ActivityRoom(

    @PrimaryKey(autoGenerate = true) val id: Int,

    @ColumnInfo(name = "activity_type") val type: Int,

    @ColumnInfo(name = "start_time") val startTime: Long,

    @ColumnInfo(name = "end_time") val endTime: Long,

    @ColumnInfo(name = "coordinates") val coordinates: List<Pair<Double, Double>>
)