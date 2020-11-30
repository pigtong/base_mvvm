package com.example.basemvvm.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "holiday_cards", primaryKeys = ["card_id"])
data class HolidayCard (
        @ColumnInfo(name = "card_id") @SerializedName("id") val id : Int,
        @ColumnInfo(name = "card_title") @SerializedName("title") val title : String,
        @ColumnInfo(name = "card_tag") @SerializedName("tag") val tag : String,
        @ColumnInfo(name = "card_message") @SerializedName("message") val message : String,
        @ColumnInfo(name = "card_sender") @SerializedName("sender") val sender : User,
        @ColumnInfo(name = "card_sent_date")  @SerializedName("date_sent") val sentDate : String,
)