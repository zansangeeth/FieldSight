package com.sangeeth.fieldsight

data class investigation(
    val id: Int,
    val description: String,
    val dateAssigned: String,
    val priority: Priority,
    var status: Status,
    val latitude: Double,
    val longitude: Double
)
