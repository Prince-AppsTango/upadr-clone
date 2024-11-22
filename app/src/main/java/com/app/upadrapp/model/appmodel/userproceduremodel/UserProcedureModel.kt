package com.app.upadrapp.model.appmodel.userproceduremodel

data class UserProcedureModel(
    val completedUserProcedures: List<CompletedUserProcedure>,
    val upcomingUserProcedures: List<UpcomingUserProcedure>
)