package com.app.upadrapp.model.authmodel.loginuserresponsemodel

data class LoginParameterModel(
    val emailAddress: String,
    val password: String,
    val userType: String="Consumer"
)