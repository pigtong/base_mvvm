package com.example.basemvvm.data.source.repository

import com.example.basemvvm.data.model.HolidayCard

interface HolidayCardRepository {

    //remote
    suspend fun getHolidayCards(successHandler: (List<HolidayCard>) -> Unit, errorHandler: (String) -> Unit)
}