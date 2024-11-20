package com.example.hciapp.data

class DataSourceException(
    var code: Int,
    message: String,
) : Exception(message)
