package com.example.basemvvm.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "holiday_cards", primaryKeys = ["card_id"])
data class HolidayCard (
        @ColumnInfo(name =  "card_id") val id : Int,
        @ColumnInfo(name = "card_title") val title : String,
        @ColumnInfo(name = "card_tag") val tag : String,
        @ColumnInfo(name = "card_message") val message : String,
        @ColumnInfo(name = "card_sender") val sender : User,
        @ColumnInfo(name = "card_date_sent") val dateSend : String,
)