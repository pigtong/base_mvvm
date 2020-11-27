package com.example.basemvvm.data.source.repository

import com.example.basemvvm.data.model.HolidayCard
import com.example.basemvvm.data.source.HolidayCardDataSource

class HolidayCardRepositoryImpl(
        private val holidayCardRemoteDataSource: HolidayCardDataSource
) : HolidayCardRepository{

    override suspend fun getHolidayCards(successHandler: (List<HolidayCard>) -> Unit, errorHandler: (String) -> Unit) {
        holidayCardRemoteDataSource.getHolidayCards(successHandler, errorHandler)
    }
}