package com.example.basemvvm.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "user", primaryKeys = ["user_id"])
data class User (
        @ColumnInfo(name =  "user_id") val id : Int,
        @ColumnInfo(name =  "user_name") val name : String,
        @ColumnInfo(name =  "user_nickname") val nickName : String,
        @ColumnInfo(name =  "user_birthdate") val birthdate : String,
)