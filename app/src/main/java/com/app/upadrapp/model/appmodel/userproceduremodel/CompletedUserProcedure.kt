package com.app.upadrapp.model.appmodel.userproceduremodel

data class CompletedUserProcedure(
    val dateTime: String,
    val procedure: Procedure,
    val procedureSet: ProcedureSetX,
    val userProcedureId: String
)