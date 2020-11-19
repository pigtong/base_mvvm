package com.example.basemvvm.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "language", primaryKeys = ["language_id"])
data class Language(
    @ColumnInfo(name = "language_id") val id: Int?,
    @ColumnInfo(name = "language_code") val code: String?,
    @ColumnInfo(name = "language_name") val name: String?
)