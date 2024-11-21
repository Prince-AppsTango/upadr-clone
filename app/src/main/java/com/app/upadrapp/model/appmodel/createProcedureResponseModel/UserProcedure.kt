package com.app.upadrapp.model.appmodel.createProcedureResponseModel

data class UserProcedure(
    val dateTime: String,
    val procedure: Procedure,
    val procedureSet: ProcedureSetX,
    val userProcedureId: String
)