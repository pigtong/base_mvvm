package com.example.basemvvm.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user", primaryKeys = ["user_id"])
data class User (
        @ColumnInfo(name = "user_id") @SerializedName("id") val id : Int,
        @ColumnInfo(name = "user_name") @SerializedName("name") val name : String,
        @ColumnInfo(name = "user_nickname") @SerializedName("nickname") val nickName : String,
        @ColumnInfo(name = "user_birthdate") @SerializedName("birthday") val birthday : String,
)