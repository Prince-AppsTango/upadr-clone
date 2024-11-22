package com.app.upadrapp.model.appmodel.createProcedureResponseModel

data class Procedure(
    val createdAt: String,
    val numberOfDefaultSteps: Int,
    val numberOfSets: Int,
    val numberOfTotalSteps: Int,
    val procedureId: String,
    val status: String,
    val steps: List<Step>,
    val title: String,
    val updatedAt: String
)