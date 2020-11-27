package com.example.basemvvm.data.source

import com.example.basemvvm.data.model.HolidayCard
import org.xml.sax.ErrorHandler

interface HolidayCardDataSource {

    //remote
    suspend fun getHolidayCards(successHandler: (List<HolidayCard>) -> Unit, errorHandler: (String) -> Unit)
}