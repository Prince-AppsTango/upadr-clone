package com.app.upadrapp.model.appmodel.proceduremodel

data class Pagination(
    val currentPage: Int,
    val lastPage: Int,
    val perPage: Long,
    val totalItems: Int
)