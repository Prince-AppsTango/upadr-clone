package com.app.upadrapp.model.appmodel.userproceduremodel

data class UpcomingUserProcedure(
    val dateTime: String,
    val procedure: Procedure,
    val procedureSet: ProcedureSetX,
    val userProcedureId: String
)