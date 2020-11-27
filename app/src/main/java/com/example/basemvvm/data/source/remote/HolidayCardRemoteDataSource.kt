package com.example.basemvvm.data.source.remote

import com.example.basemvvm.data.model.HolidayCard
import com.example.basemvvm.data.source.HolidayCardDataSource

class HolidayCardRemoteDataSource(private val exampleApiService: ExampleApiService) : HolidayCardDataSource, BaseRemoteDataSource<List<HolidayCard>>() {

    override suspend fun getHolidayCards(successHandler: (List<HolidayCard>) -> Unit, errorHandler: (String) -> Unit) {
        makeCall(exampleApiService.getHolidayCards(),
                {successHandler(it)},
                {errorHandler(it)})
    }
}