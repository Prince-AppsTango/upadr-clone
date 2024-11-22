package com.app.upadrapp.model.appmodel.procedurestepsmodel

data class UserProcedures(
    val dateTime: String,
    val procedure: Procedure,
    val procedureSet: ProcedureSetX,
    val userProcedureId: String
)