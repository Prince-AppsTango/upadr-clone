package com.app.upadrapp.model.appmodel.procedurestepsmodel

data class Step(
    val contentViewedAt: Any,
    val createdAt: String,
    val description: String,
    val isBeforeProcedure: Boolean,
    val notificationTriggerTime: String,
    val procedureSet: ProcedureSet,
    val procedureStepId: String,
    val procedureStepImageUrl: String,
    val updatedAt: String,
    val `when`: String
)