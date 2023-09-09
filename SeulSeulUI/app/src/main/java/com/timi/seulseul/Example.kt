package com.timi.seulseul

data class Example(
    val result: Result
)

data class Result(
    val lane: List<Lane>,
    val totalCityList: TotalCityList,
    val totalCount: Int
)

data class Lane(
    val busCityCode: Int,
    val busCityName: String,
    val busCompanyID: String,
    val busCompanyNameKor: String,
    val busEndPoint: String,
    val busFirstTime: String,
    val busID: Int,
    val busInterval: String,
    val busLastTime: String,
    val busNo: String,
    val busStartPoint: String,
    val bus_Interval_Sat: String,
    val bus_Interval_Sun: String,
    val bus_Interval_Week: String,
    val localBusID: String,
    val type: Int
)

data class TotalCityList(
    val includeCity: List<IncludeCity>
)

data class IncludeCity(
    val CID: Int,
    val cityName: String
)